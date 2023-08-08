package com.count.icount.company.model.dto;


import com.count.icount.company.model.entity.Company;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class CompanyDto {
    private String comCode;
    private String businessNumber;
    private String name;
    private String address;
    private String telephoneNum;
    private String ceo;
    private String businessType; // enum으로 가야할듯?

    public static CompanyDto of(Company company){
        return CompanyDto.builder()
                .comCode(company.getComCode())
                .businessNumber(company.getBusinessNumber())
                .name(company.getName())
                .address(company.getAddress())
                .telephoneNum(company.getTelephoneNum())
                .ceo(company.getCeo())
                .businessType(company.getBusinessType())
                .build();
    }

}
