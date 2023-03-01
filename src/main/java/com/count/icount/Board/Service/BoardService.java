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

import java.util.ArrayList;
import java.util.Enumeration;
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
                    BoardResponseDto.builder()
                            .id(board.getId())
                            .writer(board.getWriter())
                            .title(board.getTitle())
                            .content(board.getContent())
                            .createdDate(board.getCreatedDate())
                            .modifiedDate(board.getModifiedDate())
                            .build()
            );
        }

        return boardResponseDtos;
    }
    /*
        boardRepository.save(requestDto.getTitle(), requestDto.getContent()

                .build()
        );
        */

//    public Boolean save () {
//        boardRepository.save(requestDto.getTitle(), requestDto.getContent()
//                .build);
//
//        return true;
//    }
}
