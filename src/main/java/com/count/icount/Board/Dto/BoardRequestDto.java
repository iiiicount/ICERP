package com.count.icount.Board.Dto;

import com.count.icount.Board.Model.Entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
public class BoardRequestDto {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private char is_notice;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Board ToEntity() {
        Board board = Board.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .build();
        return board;
    }

    public static BoardRequestDto of(Board board) {
        return builder()
                .id(board.getId())
                .writer(board.getWriter())
                .title(board.getTitle())
                .content(board.getContent())
                .is_notice(board.getIs_notice())
                .createdDate(board.getCreatedDate())
                .modifiedDate(board.getModifiedDate())
                .build();
    }
}
