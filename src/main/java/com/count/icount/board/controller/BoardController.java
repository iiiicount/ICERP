package com.count.icount.board.controller;

import com.count.icount.board.dto.BoardRequestDto;
import com.count.icount.board.dto.BoardResponseDto;
import com.count.icount.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {
    private final BoardService boardService;

    @GetMapping("")
    public ResponseEntity<List<BoardResponseDto>> getBoard () {
        return ResponseEntity.ok(boardService.get());
    }

    @GetMapping("/writer/{writer}")
    public ResponseEntity<List<BoardResponseDto>> getBoardByWriter(@PathVariable("writer") String writer) {
        return ResponseEntity.ok(boardService.getBoardByWriter(writer));
    }
    @PostMapping("")
    public ResponseEntity<BoardResponseDto> saveBoard(@RequestBody BoardRequestDto boardRequestDto)  {
        // log 사용법
        // log.info("Board save Controller : ");
        return ResponseEntity.ok(boardService.save(boardRequestDto));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<BoardResponseDto> deleteBoard (@PathVariable("id") long id) {
        return ResponseEntity.ok(boardService.delete(id));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<BoardResponseDto> modify (@PathVariable("id") long id, @RequestBody BoardRequestDto boardRequestDto) {
        return ResponseEntity.ok(boardService.modify(id, boardRequestDto));
    }
}