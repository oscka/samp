package com.samp.board.query.service;

import com.samp.board.query.client.QueryBoardClient;
import com.samp.board.query.dto.BoardDto;
import com.samp.board.query.repository.QueryBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class QueryBoardService {

    private final QueryBoardRepository queryBoardRepository;
    private final QueryBoardClient queryBoardClient;

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
        BoardDto boardDto = queryBoardRepository.board(num);
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
