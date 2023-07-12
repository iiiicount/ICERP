package com.count.icount.Trade.sell.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellDetailRequestDto {
    private Long id;
    private String comCode;
    private Long sellId;
    private int quantity;
    private String beego;

    private String userName;
}
