package com.count.icount.trade.sell.model.dto;

import com.count.icount.trade.sell.model.entity.Sell;
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

    private String comCode;

    private Date date;

    public static SellResponseDto of(Sell sell) {
        return builder()
                .id(sell.getId())
                .comCode(sell.getComCode())
                .userName(sell.getUserName())
                .businessId(sell.getBusinessId())
                .detailCode(sell.getDetailCode())
                .date(sell.getDate())
                .build();
    }
}


