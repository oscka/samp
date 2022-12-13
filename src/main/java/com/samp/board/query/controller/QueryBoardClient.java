package com.samp.board.query.controller;


import com.samp.board.query.dto.BoardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "Service", url = "${api.board.url}")
public interface QueryBoardClient {

    @GetMapping("/samp/api/v1/boards/list")
    public List<BoardDto> boardList(@RequestParam(value = "size", defaultValue = "10") int size, @RequestParam(value = "page", defaultValue = "1") int page);

}
