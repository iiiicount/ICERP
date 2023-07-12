package com.count.icount.Trade.sell.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data // getter setter등 다 있음
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellRequestDto {
    private Long id;
    private Long businessId;
    private String userName;
    private String detailCode;

    private String comCode;

    private Date date;


}
