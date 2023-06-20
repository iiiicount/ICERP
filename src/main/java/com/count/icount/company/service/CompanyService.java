package com.count.icount.company.service;

import com.count.icount.company.Model.Entity.Company;
import com.count.icount.company.Model.dto.CompanyDto;
import com.count.icount.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void SaveCompany(CompanyDto companyDto){

        companyRepository.save(Company.of(companyDto));
    }

}
