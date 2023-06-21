package com.count.icount.company.controller;

import com.count.icount.company.Model.dto.AddCompanyResponseDto;
import com.count.icount.company.Model.dto.CompanyDto;
import com.count.icount.company.service.CompanyService;
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
    public ResponseEntity<?> addCompany(@RequestParam CompanyDto companyDto){

        CompanyDto newCompanyDto = this.companyService.saveCompany(companyDto);

        return new ResponseEntity<>(
                AddCompanyResponseDto.builder()
                        .save(true)
                        .companyDto(newCompanyDto)
                , HttpStatus.OK
        );
    }


}
