package com.samp.board.query.controller;

import com.samp.board.query.dto.BoardDto;
import com.samp.board.query.service.QueryBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/samp/api/v1/boards")
@RequiredArgsConstructor
@Tag(name = "게시판", description = "게시판")
@Slf4j
public class QueryBoardController {

    private final QueryBoardService queryBoardService;

    @Operation(summary = "게시물 전체 건수 조회", description = "게시물 전체 건수를 조회합니다.")
    @GetMapping("/totalCount")
    public int totalCount() {
        return (int) queryBoardService.totalCount();
    }

    @Operation(summary = "게시판 목록 조회", description = "게시판 목록을 페이지로 조회합니다.")
    @GetMapping("/list")
    public List<BoardDto> boardList(@RequestParam(value = "size", defaultValue = "10") int size, @RequestParam(value = "page", defaultValue = "1") int page) {
        log.info("boarList Request Param size : {}, page : {}", size, page);
        List<BoardDto> boardList = queryBoardService.boardList(size, page);
        return boardList;
    }

    @Operation(summary = "게시판 검색", description = "해당 게시물을 조회합니다.")
    @GetMapping("/search")
    public List<BoardDto> boardSearch(@RequestParam("search") String search) {
        return queryBoardService.boardSearch(search + "%");
    }

    @Operation(summary = "게시판 조회", description = "해당 게시물을 조회합니다.")
    @GetMapping("/{num}")
    public BoardDto board(@Parameter(description="게시물 번호") @PathVariable("num") int num) {
        BoardDto boardDto = queryBoardService.board(num);
        return boardDto;
    }

    @Operation(summary = "[Feign] 게시판 목록 조회", description = "게시판 목록을 페이지로 조회합니다.")
    @GetMapping("/listFeign")
    public List<BoardDto> boardListFeign(@RequestParam(value = "size", defaultValue = "10") int size, @RequestParam(value = "page", defaultValue = "1") int page) {
        log.info("boarList Request Param size : {}, page : {}", size, page);
        List<BoardDto> boardList = queryBoardService.boardListFeign(size, page);
        return boardList;
    }

    @Operation(summary = "[Feign] 게시판 검색", description = "해당 게시물을 조회합니다.")
    @GetMapping("/searchFeign")
    public List<BoardDto> boardSearchFeign(@RequestParam("search") String search) {
        return queryBoardService.boardSearchFeign(search + "%");
    }

    @Operation(summary = "[Feign] 게시판 조회", description = "해당 게시물을 조회합니다.")
    @GetMapping("/feign/{num}")
    public BoardDto boardFeign(@Parameter(description="게시물 번호") @PathVariable("num") int num) {
        BoardDto boardDto = queryBoardService.boardfeign(num);
        return boardDto;
    }
}
