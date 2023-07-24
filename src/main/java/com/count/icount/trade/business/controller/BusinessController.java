package com.count.icount.trade.business.controller;

import com.count.icount.trade.business.model.dto.BusinessRequestDto;
import com.count.icount.trade.business.model.dto.BusinessResponseDto;
import com.count.icount.trade.business.model.dto.GetBusinessResponseDto;
import com.count.icount.trade.business.service.BusinessService;
import com.count.icount.annotation.AuthInfo;
import com.count.icount.model.AuthUserInfo;
import com.count.icount.exception.CBusinessException;
import com.count.icount.exception.handler.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/business")
public class BusinessController {
    private final BusinessService businessService;

    @PostMapping
    public ResponseEntity<BusinessResponseDto> saveBusiness(@AuthInfo AuthUserInfo auth,
                                                            @RequestBody BusinessRequestDto business) {
        if (business.getId() != null) {
            throw new CBusinessException("ID는 임의로 지정할 수 없습니다.", ErrorCode.WRONG_DATA);
        }
        var result = businessService.saveBusiness(auth.getComCode(), business);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetBusinessResponseDto> updateBusiness(@AuthInfo AuthUserInfo auth,
                                                                 @PathVariable("id") Long id,
                                                                 @RequestBody BusinessRequestDto business) {
        if(business.getCode() == null || business.getName() == null) {
            throw new CBusinessException("필수값이 누락되었습니다. (필수값: code, name)", ErrorCode.WRONG_DATA);
        }

        var result = businessService.updateBusiness(id, auth.getComCode(), business);
        if(result == null) {
            throw new CBusinessException("거래처정보를 수정할 수 없습니다.", ErrorCode.NOT_EXIST_TARGET);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BusinessResponseDto> deleteBusiness(@AuthInfo AuthUserInfo auth,
                                                              @PathVariable("id") Long id) {
        var result = businessService.deleteBusiness(auth.getComCode(), id);
        if(result == null) {
            throw new CBusinessException("거래처정보를 삭제할 수 없습니다.", ErrorCode.NOT_EXIST_TARGET);
        }
        return ResponseEntity.ok(result);
    }
}
