package com.count.icount.Trade.sell.Comtroller;

import com.count.icount.Trade.sell.Dto.SellListResponseDto;
import com.count.icount.Trade.sell.Dto.SellRequestDto;
import com.count.icount.Trade.sell.Dto.SellResponseDto;
import com.count.icount.Trade.sell.Service.SellService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 컨트롤러라는 뜻
@RequestMapping("/sell") // url : boards/ 로 시작
@RequiredArgsConstructor // 뭐더라?
@Log4j2 // log 출력
public class SellController {
    private final SellService sellService;
    @PostMapping
    public ResponseEntity<SellResponseDto> saveSell(@RequestBody SellRequestDto sellRequestDto)  {
        log.info("user : " + sellRequestDto.getUserName());
        return ResponseEntity.ok(sellService.save(sellRequestDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<SellResponseDto> getSell(@PathVariable("id") Long id)  {
        return ResponseEntity.ok(sellService.get(id));
    }

    @GetMapping()
    public ResponseEntity<SellListResponseDto> getAll() {
        return ResponseEntity.ok(sellService.getAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        return ResponseEntity.ok(sellService.delete(id));
    }

}
