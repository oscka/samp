package com.samp.board.query.client;


import com.samp.board.query.dto.BoardDto;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "Service", url = "${api.board.url}", fallbackFactory = QueryBoardClientFallbackFactory.class)
public interface QueryBoardClient {

    @GetMapping("/api/v1/boards/list")
    public List<BoardDto> boardList(@RequestParam(value = "size", defaultValue = "10") int size, @RequestParam(value = "page", defaultValue = "1") int page);

    @GetMapping("/api/v1/boards/search")
    public List<BoardDto> boardSearch(@RequestParam("search") String search);

    @GetMapping("/api/v1/boards/{num}")
    public BoardDto board(@Parameter(description="게시물 번호") @PathVariable("num") int num);
}
