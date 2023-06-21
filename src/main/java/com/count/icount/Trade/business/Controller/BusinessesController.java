package com.count.icount.trade.business.Controller;

import com.count.icount.trade.business.Model.Dto.GetBusinessResponseDto;
import com.count.icount.trade.business.Service.BusinessService;
import com.count.icount.annotation.AuthInfo;
import com.count.icount.model.AuthUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/businesses")
public class BusinessesController {
    private final BusinessService businessService;

    @GetMapping
    public ResponseEntity<List<GetBusinessResponseDto>> getCompanyBusinesses(@AuthInfo AuthUserInfo auth,
                                                                             @PageableDefault(size = 20, sort = {"enrollDt"}, direction = Sort.Direction.DESC) Pageable page) {
        var result = businessService.getBusinesses(auth.getComCode(), page);
        return ResponseEntity.ok(result);
    }
}
