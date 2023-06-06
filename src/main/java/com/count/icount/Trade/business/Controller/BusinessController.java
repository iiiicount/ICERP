package com.count.icount.Trade.business.Controller;

import com.count.icount.Trade.business.Model.Dto.BusinessRequestDto;
import com.count.icount.Trade.business.Model.Dto.BusinessResponseDto;
import com.count.icount.Trade.business.Service.BusinessService;
import com.count.icount.annotation.AuthInfo;
import com.count.icount.annotation.AuthUserInfo;
import com.count.icount.exception.CBusinessException;
import com.count.icount.exception.handler.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
