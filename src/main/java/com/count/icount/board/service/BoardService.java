package com.count.icount.board.service;

import com.count.icount.board.dto.BoardRequestDto;
import com.count.icount.board.dto.BoardResponseDto;
import com.count.icount.board.model.entity.Board;
import com.count.icount.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Log4j2
public class BoardService {
    // 레포지토리
    private final BoardRepository boardRepository;
    @Transactional
    public List<BoardResponseDto> get() {
        List<Board> boards = boardRepository.findAll();
        List<BoardResponseDto> boardResponseDtos = new ArrayList<>();

        for (var board : boards) {
            boardResponseDtos.add(
                    BoardResponseDto.of(board)
            );
        }

        return boardResponseDtos;
    }

    @Transactional
    public List<BoardResponseDto> getBoardByWriter(String writer) {
        List<Board> boards = boardRepository.findByWriter(writer);
        List<BoardResponseDto> boardResponseDtos = new ArrayList<>();

        for (var board : boards) {
            boardResponseDtos.add(
                    BoardResponseDto.of(board)
            );
        }

        return boardResponseDtos;
    }

    @Transactional
    public BoardResponseDto save (BoardRequestDto boardRequestDto) {

        Board newBoard = Board.of(boardRequestDto);

        Board board = boardRepository.save(newBoard);

        return BoardResponseDto.of(newBoard);
    }

    @Transactional
    public BoardResponseDto delete (long id) {
        Board newBoard = boardRepository.findById(id);

        boardRepository.delete(newBoard);

        return BoardResponseDto.of(newBoard);
    }

    @Transactional
    public BoardResponseDto modify (long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id);
        boolean modified = false;

        if (board.getTitle() != null) {
            board.setTitle(boardRequestDto.getTitle());
            modified = true;
        }

        if (board.getContent() != null) {
            board.setContent(boardRequestDto.getContent());
            modified = true;
        }

        if (modified == true) {
            board.setModifiedDate(LocalDateTime.now());
            boardRepository.save(board);
        }

        return BoardResponseDto.of(board);
    }
}
