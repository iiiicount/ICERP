package com.count.icount.trade.sell.dto;

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
