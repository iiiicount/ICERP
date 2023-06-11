package com.count.icount.Trade.business.Model.Dto;

import com.count.icount.Trade.business.Model.Entity.Business;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetBusinessResponseDto {
    private Long id;
    private String comCode;
    private String code;
    private String name;
    private String businessNum;
    private String tel;
    private String fax;
    private String address;
    private Long bankId;
    private String bankName;
    private String accountNum;
    private Timestamp enrollDt;
    private Timestamp updateDt;

    public static GetBusinessResponseDto of(Business business){
        return GetBusinessResponseDto.builder()
                .id(business.getId())
                .comCode(business.getCompany().getComCode())
                .code(business.getCode())
                .name(business.getName())
                .businessNum(business.getBusinessNum())
                .tel(business.getTel())
                .fax(business.getFax())
                .address(business.getAddress())
                .bankId(business.getBank() != null ? business.getBank().getId() : null)
                .bankName(business.getBank() != null ? business.getBank().getBankName() : null)
                .accountNum(business.getAccountNum())
                .enrollDt(business.getEnrollDt())
                .updateDt(business.getUpdateDt())
                .build();
    }
}
