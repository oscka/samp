package com.samp.board.command.controller;

import com.samp.board.command.service.CommandBoardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("samp/api/v1/boards")
@RequiredArgsConstructor
@Tag(name = "게시판", description = "게시판")
@Slf4j
public class CommandBoardController {
    private final CommandBoardService commandBoardService;

}
