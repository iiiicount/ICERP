package com.count.icount.trade.business.model.dto;

import com.count.icount.trade.business.model.entity.Business;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessResponseDto {
    private Long id;
    private String comCode;
    private String code;
    private String name;
    private Timestamp enrollDt;
    private Timestamp updateDt;
    public static BusinessResponseDto of(Business business){
        return BusinessResponseDto.builder()
                .id(business.getId())
                .comCode(business.getCompany().getComCode())
                .code(business.getCode())
                .name(business.getName())
                .enrollDt(business.getEnrollDt())
                .updateDt(business.getUpdateDt())
                .build();
    }
}
