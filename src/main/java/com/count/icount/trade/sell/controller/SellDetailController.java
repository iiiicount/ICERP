package com.count.icount.trade.sell.controller;

import com.count.icount.trade.sell.dto.SellDetailListRequestDto;
import com.count.icount.trade.sell.dto.SellDetailListResponseDto;
import com.count.icount.trade.sell.service.SellDetailService;
import com.count.icount.annotation.AuthInfo;
import com.count.icount.model.AuthUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sellDetail")
@RequiredArgsConstructor
@Log4j2
public class SellDetailController {
    private final SellDetailService sellDetailService;

    @PostMapping("")
    public ResponseEntity<SellDetailListResponseDto> save(@AuthInfo AuthUserInfo auth, @RequestBody SellDetailListRequestDto sellDetailListRequestDto) {
        return ResponseEntity.ok(sellDetailService.save(auth, sellDetailListRequestDto));
    }

//    @GetMapping("{id}")
//    public ResponseEntity<SellDetailResponseDto> getOne(@AuthInfo AuthUserInfo auth, @PathVariable("id") Long id) {
//        return ResponseEntity.ok(sellDetailService.getOne(auth, id));
//    }

    @GetMapping("")
    public ResponseEntity<SellDetailListResponseDto> getAll(@AuthInfo AuthUserInfo auth) {
        return ResponseEntity.ok(sellDetailService.getAll(auth));
    }

    @DeleteMapping("id")
    public ResponseEntity<Long> delete(@AuthInfo AuthUserInfo auth, @PathVariable("id") Long id) {
        return ResponseEntity.ok(sellDetailService.delete(auth, id));
    }

    @PutMapping("")
    public ResponseEntity<Long> modify(@AuthInfo AuthUserInfo auth, @RequestBody SellDetailListRequestDto sellDetailListRequestDto) {
        return ResponseEntity.ok(sellDetailService.modify(auth, sellDetailListRequestDto));
    }


}
