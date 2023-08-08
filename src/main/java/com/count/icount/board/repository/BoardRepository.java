package com.count.icount.board.repository;

import com.count.icount.board.model.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findById(long id);
    List<Board> findAll();
    List<Board> findByWriter(String writer);
}
