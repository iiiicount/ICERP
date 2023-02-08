package com.count.icount.Trade.Sell.Dto;

import lombok.Builder;
import lombok.Data;

@Data // getter setter등 다 있음
@Builder
public class SellBoardRequestDto {
    private String title;
    private String content;
}
