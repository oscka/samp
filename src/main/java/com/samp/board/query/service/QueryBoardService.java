package com.samp.board.query.service;

import com.samp.board.query.client.QueryBoardClient;
import com.samp.board.query.dto.BoardDto;
import com.samp.board.query.repository.QueryBoardRepository;
import com.samp.common.component.redis.RedisOperator;
import com.samp.common.constants.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class QueryBoardService {

    private final QueryBoardRepository queryBoardRepository;
    private final QueryBoardClient queryBoardClient;
    private final RedisOperator<BoardDto> redisOperator;

    public int totalCount() {
        return (int) queryBoardRepository.count();
    }

    public List<BoardDto> boardList(int size, int page) {

        PageRequest pageRequest = PageRequest.of((page - 1), size);
        List<BoardDto> boardList = queryBoardRepository.boardList(pageRequest.getPageSize(), pageRequest.getOffset());
        return boardList;
    }

    public List<BoardDto> boardSearch(String search) {
        return queryBoardRepository.boardSearch(search);
    }

    public BoardDto board(int num) {

        // 1. Redis key 생성
        String key = Constant.BOARD_KEY + String.valueOf(num);
        log.info("redis key : {}", key);

        // 2. redis cache를 조회 한다.
        BoardDto boardDto = redisOperator.getValue(key);
        log.info("캐시 조회 boardDto : {}", boardDto);

        if(boardDto == null) {
            // 3. cache 데이터가 없는 경우 DB에서 조회 환다.
            log.info("DB 조회");
            boardDto = queryBoardRepository.board(num);

            // 4. redis cache 데이터 시간 설정
            redisOperator.set(key, boardDto, 100, TimeUnit.SECONDS);
        }

        return boardDto;
    }

    /**
     * Open Feign boarList 호출
     * @param size
     * @param page
     * @return
     */
    public List<BoardDto> boardListFeign(int size, int page) {
        log.info("[Open Feing] board list");
        return queryBoardClient.boardList(size, page);
    }

    public List<BoardDto> boardSearchFeign(String search) {
        log.info("[Open Feing] board search");
        return queryBoardClient.boardSearch(search);
    }

    public BoardDto boardfeign(int num) {
        log.info("[Open Feing] board search");
        return queryBoardClient.board(num);
    }
}
