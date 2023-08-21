package com.count.icount.board.service;

import com.count.icount.board.dto.BoardRequestDto;
import com.count.icount.board.dto.BoardResponseDto;
import com.count.icount.board.model.entity.Board;
import com.count.icount.board.repository.BoardRepository;
import com.count.icount.board.vo.BoardVo;
import com.count.icount.page.criteria.Criteria;
import com.count.icount.page.vo.PageVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Log4j2
public class BoardService {
    // 레포지토리
    private final BoardRepository boardRepository;
    private PageVo pageVo;

    // paging 데이터로 변경
//    @Transactional
//    public List<BoardResponseDto> get() {
//        List<Board> boards = boardRepository.findAll();
//        List<BoardResponseDto> boardResponseDtos = new ArrayList<>();
//
//        for (var board : boards) {
//            boardResponseDtos.add(
//                    BoardResponseDto.of(board)
//            );
//        }
//
//        return boardResponseDtos;
//    }

//    @Transactional
//    public List<BoardResponseDto> getBoardByWriter(String writer) {
//        List<Board> boards = boardRepository.findByWriter(writer);
//        List<BoardResponseDto> boardResponseDtos = new ArrayList<>();
//
//        for (var board : boards) {
//            boardResponseDtos.add(
//                    BoardResponseDto.of(board)
//            );
//        }
//
//        return boardResponseDtos;
//    }


    // Jpa를 사용하여 페이징
//    public List<BoardResponseDto> getPagingDatas(Pageable pageable) {
//        List<Board> boards = boardRepository.findAll(pageable).getContent();
//        List<BoardResponseDto> boardResponseDtos = new ArrayList<>();
//
//        Criteria cri = Criteria.of(pageable.getPageNumber(), pageable.getPageSize());
//        PageVo pageVo = new PageVo(cri, boards.size());
//
//        for (var board: boards) {
//           boardResponseDtos.add(
//                   BoardResponseDto.of(board)
//           );
//        }
//
//        return boardResponseDtos;
//    }

    @Transactional
    public BoardResponseDto get(int pageNum, int amount) {
        List<Board> boards = boardRepository.findAll();
        List<BoardVo> boardVos = new ArrayList<>();

        Criteria cri = Criteria.of(pageNum, amount);
        pageVo = new PageVo(cri, boards.size());

        boards = boards.stream()
                .skip((cri.getPageNum() - 1) * cri.getAmount())
                .limit(cri.getAmount())
                .collect(Collectors.toList());

        for (var board : boards) {
            boardVos.add(
                    BoardVo.of(board)
            );
        }

        return BoardResponseDto.of(boardVos, pageVo);
    }

    @Transactional
    public BoardResponseDto getBoardByWriter(String writer, int pagenum, int amount) {
        List<Board> boards = boardRepository.findByWriter(writer);
        List<BoardVo> boardVos = new ArrayList<>();

        Criteria cri = Criteria.of(pagenum, amount);
        pageVo = new PageVo(cri, boards.size());

        boards.stream()
                .skip((cri.getPageNum() - 1) * cri.getAmount())
                .limit(cri.getAmount())
                .collect(Collectors.toList());

        for (var board : boards) {
            boardVos.add(
                    BoardVo.of(board)
            );
        }

        return BoardResponseDto.of(boardVos, pageVo);
    }

    @Transactional
    public BoardResponseDto save (BoardRequestDto boardRequestDto) {
        Board newBoard = Board.of(boardRequestDto);
        List<BoardVo> boards = new ArrayList<BoardVo>();

        Board board = boardRepository.save(newBoard);
        boards.add(BoardVo.of(board));

        return BoardResponseDto.of(boards);
    }

    @Transactional
    public BoardResponseDto delete (long id) {
        Board newBoard = boardRepository.findById(id);
        List<BoardVo> boards = new ArrayList<BoardVo>();

        boardRepository.delete(newBoard);
        boards.add(BoardVo.of(newBoard));

        return BoardResponseDto.of(boards);
    }

    @Transactional
    public BoardResponseDto modify (long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id);
        List<BoardVo> boards = new ArrayList<BoardVo>();

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
            boards.add(BoardVo.of(board));
        }

        return BoardResponseDto.of(boards);
    }

    public int getStartPage() {
        return pageVo.getStartPage();
    }

    public int getEndPage() {
        return pageVo.getEndPage();
    }

    public boolean hasNext() {
        return pageVo.isNext();
    }

    public boolean hasPrev() {
        return pageVo.isPrev();
    }
}
