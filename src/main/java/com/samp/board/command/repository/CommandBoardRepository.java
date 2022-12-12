package com.samp.board.command.repository;

import com.samp.board.command.domain.Board;
import org.springframework.data.repository.CrudRepository;

public interface CommandBoardRepository extends CrudRepository<Board, Integer> {

}
