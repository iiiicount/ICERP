package com.count.icount.company.service;

import com.count.icount.company.model.entity.Company;
import com.count.icount.company.model.dto.CompanyDto;
import com.count.icount.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Transactional
    public CompanyDto saveCompany(CompanyDto companyDto){

        Company newCompany = companyRepository.save(Company.of(companyDto));
        return CompanyDto.of(newCompany);
    }

}
