package com.count.icount.Board.Service;

import com.count.icount.Board.Dto.BoardRequestDto;
import com.count.icount.Board.Dto.BoardResponseDto;
import com.count.icount.Board.Model.Entity.Board;
import com.count.icount.Board.Repository.BoardRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;


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
//                BoardResponseDto.builder()
//                        .id(board.getId())
//                        .writer(board.getWriter())
//                        .title(board.getTitle())
//                        .content(board.getContent())
//                        .createdDate(board.getCreatedDate())
//                        .modifiedDate(board.getModifiedDate())
//                        .build()
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
//                    BoardResponseDto.builder()
//                            .id(board.getId())
//                            .writer(board.getWriter())
//                            .title(board.getTitle())
//                            .content(board.getContent())
//                            .createdDate(board.getCreatedDate())
//                            .modifiedDate(board.getModifiedDate())
//                            .build()
                    BoardResponseDto.of(board)
            );
        }

        return boardResponseDtos;
    }

    @Transactional
    public BoardResponseDto save (BoardRequestDto boardRequestDto) {
//        Board newBoard = Board.builder()
//                .id(boardRequestDto.getId())
//                .writer(boardRequestDto.getWriter())
//                .title(boardRequestDto.getTitle())
//                .content(boardRequestDto.getContent())
//                .createdDate(boardRequestDto.getCreatedDate())
//                .modifiedDate(boardRequestDto.getModifiedDate())
//                .build();

        Board newBoard = Board.of(boardRequestDto);

        Board board = boardRepository.save(newBoard);

//        return BoardResponseDto.builder()
//                .id(board.getId())
//                .writer(board.getWriter())
//                .title(board.getTitle())
//                .content(board.getContent())
//                .createdDate(board.getCreatedDate())
//                .modifiedDate(board.getModifiedDate())
//                .build();
        return BoardResponseDto.of(newBoard);
    }

    @Transactional
    public BoardResponseDto delete (long id) {
        Board newBoard = boardRepository.findById(id);

        boardRepository.delete(newBoard);

//        return BoardResponseDto
//                .builder()
//                .id(newBoard.getId())
//                .writer(newBoard.getWriter())
//                .title(newBoard.getTitle())
//                .content(newBoard.getContent())
//                .createdDate(newBoard.getCreatedDate())
//                .modifiedDate(newBoard.getModifiedDate())
//                .build();
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

//        return BoardResponseDto.builder()
//                .id(board.getId())
//                .writer(board.getWriter())
//                .title(board.getTitle())
//                .content(board.getContent())
//                .modifiedDate(board.getModifiedDate())
//                .createdDate(board.getCreatedDate())
//                .build();
        return BoardResponseDto.of(board);
    }
}
