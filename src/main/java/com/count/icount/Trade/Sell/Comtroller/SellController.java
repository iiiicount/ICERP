package com.count.icount.Trade.Sell.Comtroller;

import com.count.icount.Trade.Sell.Dto.SellBoardRequestDto;
import com.count.icount.Trade.Sell.Dto.SellBoardResponseDto;
import com.count.icount.Trade.Sell.Service.SellService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러라는 뜻
@RequestMapping("boards") // url : boards/ 로 시작
@RequiredArgsConstructor // 뭐더라?
@Log4j2 // log 출력
public class SellController {
    private SellService sellService;
    @PostMapping("")
    public ResponseEntity<SellBoardResponseDto> saveBoard(@RequestPart(value = "board") SellBoardRequestDto sellBoardRequestDto)  {
        // log 사용법
        // log.info("Board save Controller : ");
        return ResponseEntity.ok(sellService.save(sellBoardRequestDto));
    }
}
