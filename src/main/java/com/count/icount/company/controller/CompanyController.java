package com.count.icount.company.controller;

import com.count.icount.company.Model.dto.CompanyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @PostMapping
    public ResponseEntity<?> addCompany(@RequestParam CompanyDto companyDto){



        return null;
    }


}
