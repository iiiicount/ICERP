package com.count.icount.board.model.entity;

import com.count.icount.board.dto.BoardRequestDto;
import com.count.icount.board.dto.BoardResponseDto;
import com.count.icount.board.vo.BoardVo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writer;
    private String title;
    private String content;
    private Boolean is_notice;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

//    public static Board of(BoardResponseDto boardResponseDto) {
//        return builder()
//                .id(boardResponseDto.getId())
//                .writer(boardResponseDto.getWriter())
//                .title(boardResponseDto.getTitle())
//                .content(boardResponseDto.getContent())
//                .is_notice(boardResponseDto.getIs_notice())
//                .createdDate(boardResponseDto.getCreatedDate())
//                .modifiedDate(boardResponseDto.getModifiedDate())
//                .build();
//    }

    public static Board of(BoardVo boardVo) {
        return builder()
                .id(boardVo.getId())
                .writer(boardVo.getWriter())
                .title(boardVo.getTitle())
                .content(boardVo.getContent())
                .is_notice(boardVo.getIs_notice())
                .createdDate(boardVo.getCreatedDate())
                .modifiedDate(boardVo.getModifiedDate())
                .build();
    }

    public static Board of(BoardRequestDto boardRequestDto) {
        return builder()
                .id(boardRequestDto.getId())
                .writer(boardRequestDto.getWriter())
                .title(boardRequestDto.getTitle())
                .content(boardRequestDto.getContent())
                .is_notice(boardRequestDto.getIs_notice())
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();
    }
}
