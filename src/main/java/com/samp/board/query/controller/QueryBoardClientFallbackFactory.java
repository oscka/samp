package com.samp.board.query.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QueryBoardClientFallbackFactory implements FallbackFactory<QueryBoardClient> {
    @Override
    public QueryBoardClient create(Throwable cause) {
        return null;
    }
}
