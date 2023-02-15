package com.count.icount.Trade.sell.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data // getter setter등 다 있음
@Builder
public class SellRequestDto {
    private Long businessId;
    private String userName;
    private String detailCode;
}
