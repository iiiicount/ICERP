package com.count.icount.Board.Controller;

import com.count.icount.Board.Dto.BoardRequestDto;
import com.count.icount.Board.Dto.BoardResponseDto;
import com.count.icount.Board.Service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("boards")
@RequiredArgsConstructor
@Log4j2
public class BoardController {
    private BoardService boardService;

    @GetMapping("/board")
    public ResponseEntity<BoardResponseDto> getBoard (BoardRequestDto boardRequestDto) {
        return ResponseEntity.ok(boardService.get(boardRequestDto));
    }

//    @PostMapping("")
//    public ResponseEntity<BoardResponseDto> saveBoard(@RequestBody BoardRequestDto boardRequestDto)  {
//        // log 사용법
//        // log.info("Board save Controller : ");
//        return ResponseEntity.ok(boardService.save(boardRequestDto));
//    }
//
//    @DeleteMapping("")
//    public ResponseEntity<BoardResponseDto> deleteBoard (BoardRequestDto boardRequestDto) {
//        return ResponseEntity.ok(boardService.delete(boardRequestDto));
//    }
//    @PutMapping("")
//    public ResponseEntity<BoardResponseDto> modifyBoard (BoardRequestDto boardRequestDto) {
//        return ResponseEntity.ok(boardService.update(boardRequestDto));
//    }

}
