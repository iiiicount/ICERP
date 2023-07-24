package com.count.icount.company.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AddCompanyResponseDto {
    private boolean save;
    private CompanyDto companyDto;
}
