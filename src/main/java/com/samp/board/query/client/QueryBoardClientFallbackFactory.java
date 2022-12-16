package com.samp.board.query.client;

import com.samp.board.query.dto.BoardDto;
import com.samp.common.dto.ResultMessage;
import com.samp.common.utils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Component
public class QueryBoardClientFallbackFactory implements FallbackFactory<QueryBoardClient> {
    @Override
    public QueryBoardClient create(Throwable cause) {

        ResultMessage resultMessage = ExceptionUtil.getResponseMessage(cause);

        return new QueryBoardClient() {
            @Override
            public List<BoardDto> boardList(int size, int page) {
                log.info("fallback called : boardList = {}", resultMessage);
                return (List<BoardDto>) BoardDto.builder().build();
            }

            @Override
            public List<BoardDto> boardSearch(String search) {
                log.info("fallback called : boardSearch = {}", resultMessage);
                return (List<BoardDto>) BoardDto.builder().build();
            }

            @Override
            public BoardDto board(int num) {
                log.info("fallback called : board = {}", resultMessage);
                return BoardDto.builder().build();
            }
        };
    }
}
