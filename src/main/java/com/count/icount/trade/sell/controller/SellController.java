package com.count.icount.trade.sell.controller;

import com.count.icount.trade.sell.dto.*;
import com.count.icount.trade.sell.service.SellService;
import com.count.icount.annotation.AuthInfo;
import com.count.icount.model.AuthUserInfo;
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
    @PostMapping("")
    public ResponseEntity<SellListResponseDto> save(@AuthInfo AuthUserInfo auth, @RequestBody SellListRequestDto sellListRequestDto) {
        return ResponseEntity.ok(sellService.save(auth, sellListRequestDto));
    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<SellResponseDto> getOne(@AuthInfo AuthUserInfo auth, @PathVariable("id") Long id) {
//        return ResponseEntity.ok(sellService.getOne(auth, id));
//    }

    @GetMapping("")
    public ResponseEntity<SellListResponseDto> getAll(@AuthInfo AuthUserInfo auth) {
        return ResponseEntity.ok(sellService.getAll(auth));
    }

    @DeleteMapping("id")
    public ResponseEntity<Long> delete(@AuthInfo AuthUserInfo auth, @PathVariable("id") Long id) {
        return ResponseEntity.ok(sellService.delete(auth, id));
    }

    @PutMapping("")
    public ResponseEntity<Long> modify(@AuthInfo AuthUserInfo auth, @RequestBody SellListRequestDto sellListRequestDto) {
        return ResponseEntity.ok(sellService.modify(auth, sellListRequestDto));
    }
}
