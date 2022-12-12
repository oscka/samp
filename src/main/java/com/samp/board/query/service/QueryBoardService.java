package com.samp.board.query.service;

import com.samp.board.query.dto.BoardDto;
import com.samp.board.query.repository.QueryBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryBoardService {

    private final QueryBoardRepository queryBoardRepository;

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
}
