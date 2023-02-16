package com.count.icount.Board.Service;

import com.count.icount.Board.Dto.BoardRequestDto;
import com.count.icount.Board.Dto.BoardResponseDto;
import com.count.icount.Board.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Log4j2
public class BoardService {
    // 레포지토리
    private final BoardRepository boardRepository;
    @Transactional
    public BoardResponseDto get(BoardRequestDto requestDto) {

        return BoardResponseDto.builder()
                .id(requestDto.getId())
                .writer(requestDto.getWriter())
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .createdDate(requestDto.getCreatedDate())
                .modifiedDate(requestDto.getModifiedDate())
                .build();

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
