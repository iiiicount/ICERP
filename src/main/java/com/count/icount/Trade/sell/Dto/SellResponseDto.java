package com.count.icount.Trade.sell.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data // getter setter등 다 있음
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellResponseDto {
    private Long id;
    private Long businessId;
    private String userName;
    private String detailCode;
    private Date date;
}
