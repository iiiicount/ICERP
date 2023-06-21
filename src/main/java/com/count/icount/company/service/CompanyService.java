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

    public CompanyDto saveCompany(CompanyDto companyDto){

        Company newCompany = companyRepository.save(Company.of(companyDto));
        return CompanyDto.of(newCompany);
    }

}
