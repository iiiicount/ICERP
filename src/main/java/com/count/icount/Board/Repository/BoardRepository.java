package com.count.icount.Board.Repository;

import com.count.icount.Board.Model.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> getBoardList();
    Board findByBoardId(Long id);
    Board findByWirter(String writer);
}
