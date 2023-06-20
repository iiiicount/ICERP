package com.count.icount.company.Model.Entity;

import com.count.icount.company.Model.dto.CompanyDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String comCode;
    private String businessNumber;
    private String name;
    private String address;
    private String telephoneNum;
    private String ceo;
    private String businessType; // enum으로 가야할듯?

    public static Company of(CompanyDto companyDto){
        return Company.builder()
                .comCode(companyDto.getComCode())
                .businessNumber(companyDto.getBusinessNumber())
                .name(companyDto.getName())
                .address(companyDto.getAddress())
                .telephoneNum(companyDto.getTelephoneNum())
                .ceo(companyDto.getCeo())
                .businessType(companyDto.getBusinessType())
                .build();
    }

}
