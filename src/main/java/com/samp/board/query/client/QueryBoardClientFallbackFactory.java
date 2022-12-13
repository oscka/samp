package com.samp.board.query.client;

import com.samp.board.query.dto.BoardDto;
import com.samp.common.dto.ResultMessage;
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

        ResultMessage resultMessage =
        @Override
        public List<BoardDto> boardList(@RequestParam(value = "size", defaultValue = "10") int size, @RequestParam(value = "page", defaultValue = "1") int page) {
            log.info("fallback called : boardList = {}");
        }
        return null;
    }
}
