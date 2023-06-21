package com.count.icount.Trade.sell.Comtroller;

import com.count.icount.Trade.sell.Dto.SellDetailListResponseDto;
import com.count.icount.Trade.sell.Dto.SellDetailRequestDto;
import com.count.icount.Trade.sell.Dto.SellDetailResponseDto;
import com.count.icount.Trade.sell.Service.SellDetailService;
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
    public ResponseEntity<SellDetailResponseDto> save(@AuthInfo AuthUserInfo auth, @RequestBody SellDetailRequestDto sellDetailRequestDto) {
        return ResponseEntity.ok(sellDetailService.save(sellDetailRequestDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<SellDetailResponseDto> getOne(@AuthInfo AuthUserInfo auth, @PathVariable("id") Long id) {
        return ResponseEntity.ok(sellDetailService.getOne(id));
    }

    @GetMapping("")
    public ResponseEntity<SellDetailListResponseDto> getAll(@AuthInfo AuthUserInfo auth) {
        return ResponseEntity.ok(sellDetailService.getAll());
    }

    @DeleteMapping("id")
    public ResponseEntity<Long> delete(@AuthInfo AuthUserInfo auth, @PathVariable("id") Long id) {
        return ResponseEntity.ok(sellDetailService.delete(id));
    }


}
