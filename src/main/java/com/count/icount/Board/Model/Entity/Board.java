package com.count.icount.Board.Model.Entity;

import com.count.icount.Board.Dto.BoardRequestDto;
import com.count.icount.Board.Dto.BoardResponseDto;
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
    private char is_notice;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public static Board of(BoardResponseDto boardResponseDto) {
        return builder()
                .id(boardResponseDto.getId())
                .writer(boardResponseDto.getWriter())
                .title(boardResponseDto.getTitle())
                .content(boardResponseDto.getContent())
                .is_notice(boardResponseDto.getIs_notice())
                .createdDate(boardResponseDto.getCreatedDate())
                .modifiedDate(boardResponseDto.getModifiedDate())
                .build();
    }

    public static Board of(BoardRequestDto boardRequestDto) {
        return builder()
                .id(boardRequestDto.getId())
                .writer(boardRequestDto.getWriter())
                .title(boardRequestDto.getTitle())
                .content(boardRequestDto.getContent())
                .createdDate(boardRequestDto.getCreatedDate())
                .modifiedDate(boardRequestDto.getModifiedDate())
                .build();
    }
}
