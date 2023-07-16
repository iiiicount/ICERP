package com.count.icount.company.controller;

import com.count.icount.annotation.AuthInfo;
import com.count.icount.auth.model.enums.AuthorizationMode;
import com.count.icount.company.Model.dto.AddCompanyResponseDto;
import com.count.icount.company.Model.dto.CompanyDto;
import com.count.icount.company.service.CompanyService;
import com.count.icount.model.AuthUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;
    @PostMapping
    public ResponseEntity<?> addCompany(
            @AuthInfo(mode = AuthorizationMode.ICOUNT_ONLY) AuthUserInfo userInfo, // icount 직원만 회사 등록 가능
            @RequestParam CompanyDto companyDto
    ){
        CompanyDto newCompanyDto = this.companyService.saveCompany(companyDto);

        return new ResponseEntity<>(
                AddCompanyResponseDto.builder()
                        .save(true)
                        .companyDto(newCompanyDto)
                        .build()
                , HttpStatus.OK
        );
    }

}
