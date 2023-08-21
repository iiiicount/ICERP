package com.count.icount.board.controller;

import com.count.icount.board.dto.BoardRequestDto;
import com.count.icount.board.dto.BoardResponseDto;
import com.count.icount.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {
    private final BoardService boardService;

//    @GetMapping("")
//    public ResponseEntity<List<BoardResponseDto>> getBoard () {
//        return ResponseEntity.ok(boardService.get());
//    }
    @GetMapping("")
    public ResponseEntity<BoardResponseDto> getBoard(@RequestParam(value = "pagenum", defaultValue = "1") int pagenum,
                                                     @RequestParam(value = "amount", defaultValue = "10") int amount) {
        return ResponseEntity.ok(boardService.get(pagenum, amount));
    }

    //Jpa를 사용하여 페이징
//    @GetMapping("")
//    public ResponseEntity<List<BoardResponseDto>> getPagingBoard(Pageable pageable) {
//        return ResponseEntity.ok(boardService.getPagingDatas(pageable));
//    }

    @GetMapping("/writer/{writer}")
    public ResponseEntity<BoardResponseDto> getBoardByWriter(@PathVariable("writer") String writer,
                                                             @RequestParam(value = "pagenum", defaultValue = "1") int pagenum,
                                                             @RequestParam(value = "amount", defaultValue = "10") int amount) {
        return ResponseEntity.ok(boardService.getBoardByWriter(writer, pagenum, amount));
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
