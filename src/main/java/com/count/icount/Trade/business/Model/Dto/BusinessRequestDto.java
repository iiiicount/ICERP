package com.count.icount.trade.business.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessRequestDto {
    private Long id;
    private String code;
    private String name;
    private String businessNum;
    private String tel;
    private String fax;
    private String address;
    private Long bankId;
    private String accountNum;
    private Timestamp enrollDt;
    private Timestamp updateDt;
}
