package com.count.icount.trade.sell.model.dto;

import com.count.icount.trade.sell.model.entity.SellDetail;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SellDetailResponseDto {
    private Long id;
    private String comCode;
    private Long sellId;
    private int quantity;
    private String beego;

    private String userName;

    public static SellDetailResponseDto of(SellDetail sellDetail) {
        return builder()
                .id(sellDetail.getId())
                .comCode(sellDetail.getComCode())
                .sellId(sellDetail.getSellId())
                .quantity(sellDetail.getQuantity())
                .beego(sellDetail.getBeego())
                .userName(sellDetail.getUserName())
                .build();
    }
}
