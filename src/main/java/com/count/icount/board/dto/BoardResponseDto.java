package com.count.icount.board.dto;

import com.count.icount.board.model.entity.Board;
import com.count.icount.board.vo.BoardVo;
import com.count.icount.page.vo.PageVo;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class BoardResponseDto {
//    private Long id;
//    private String writer;
//    private String title;
//    private String content;
//    private Boolean is_notice;
//    private LocalDateTime createdDate;
//    private LocalDateTime modifiedDate;
//
//    public static BoardResponseDto of(Board board) {
//        return builder()
//                .id(board.getId())
//                .writer(board.getWriter())
//                .title(board.getTitle())
//                .content(board.getContent())
//                .is_notice(board.getIs_notice())
//                .createdDate(board.getCreatedDate())
//                .modifiedDate(board.getModifiedDate())
//                .build();
//    }
    private List<BoardVo> boards;
    private Boolean hasPrev;
    private Boolean hasNext;
    private int startPage;
    private int endPage;

    public static BoardResponseDto of (List<BoardVo> boards, PageVo pageVo) {
        return builder()
                .boards(boards)
                .hasPrev(pageVo.isPrev())
                .hasNext(pageVo.isNext())
                .startPage(pageVo.getStartPage())
                .endPage(pageVo.getEndPage())
                .build();
    }

    public static BoardResponseDto of (List<BoardVo> boards) {
        return builder()
                .boards(boards)
                .build();
    }
}
