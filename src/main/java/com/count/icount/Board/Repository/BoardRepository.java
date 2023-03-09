package com.count.icount.Board.Repository;

import com.count.icount.Board.Dto.BoardRequestDto;
import com.count.icount.Board.Dto.BoardResponseDto;
import com.count.icount.Board.Model.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findById(long id);
    List<Board> findAll();
    List<Board> findByWriter(String writer);
//    Board update(long id);
}
