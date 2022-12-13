package com.samp.board.command.controller;

import com.samp.board.command.domain.Board;
import com.samp.board.command.service.CommandBoardService;
import com.samp.common.dto.ResultMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/samp/api/v1/boards")
@RequiredArgsConstructor
@Tag(name = "게시판", description = "게시판")
@Slf4j
public class CommandBoardController {
    private final CommandBoardService commandBoardService;

    @Operation(summary = "게시판 입력", description = "게시판 입력 기능입니다.")
    @PostMapping("/registration")
    public Map<String, Object> insert(@RequestBody Board paramBoard) {
        Map<String, Object> resultMap = new HashMap<>();

        Board board = commandBoardService.insert(paramBoard);

        ResultMessage resultMessage = getResponseEntity(board.getNum());

        resultMap.put("result", resultMessage);

        return resultMap;
    }

    @Operation(summary = "게시판 수정", description = "게시판 수정 기능입니다.")
    @PostMapping("/modify")
    public Map<String, Object> updateBoard(@RequestBody Board paramBoard) {
        Map<String, Object> resultMap = new HashMap<>();

        int resultCount = commandBoardService.updateBoard(paramBoard);

        ResultMessage resultMessage = getResponseEntity(resultCount);

        resultMap.put("result", resultMessage);

        return resultMap;
    }

    @Operation(summary = "게시판 삭제", description = "게시판 삭제 기능합니다.")
    @PostMapping("/delete/{num}")
    public Map<String, Object> delete(@PathVariable("num") int num) {
        Map<String, Object> resultMap = new HashMap<>();

        int resultCount = commandBoardService.delete(num);

        ResultMessage resultMessage = getResponseEntity(resultCount);

        resultMap.put("result", resultMessage);

        return resultMap;

    }



    private ResultMessage getResponseEntity(int result) {
        if(result > 0) {
            ResultMessage resultMessage= ResultMessage.builder().successYn("Y").message("정상 처리 되었습니다.").build();
            return resultMessage;
        }
        ResultMessage resultMessage= ResultMessage.builder().successYn("N").message("서비스 처리 중 오류가 발생했습니다.").build();
        return resultMessage;
    }
}
