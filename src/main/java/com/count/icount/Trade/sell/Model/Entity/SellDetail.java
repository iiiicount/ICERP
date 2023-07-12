package com.count.icount.Trade.sell.Model.Entity;

import com.count.icount.Trade.sell.Dto.SellDetailRequestDto;
import com.count.icount.Trade.sell.Dto.SellDetailResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comCode;
    private Long sellId;
    private int quantity;
    private String beego;

    private String userName;

    public static SellDetail set(SellDetail sell1, SellDetail sell2) {
        sell1.setSellId(sell2.getSellId());
        sell1.setUserName(sell2.getUserName());
        sell1.setQuantity(sell2.getQuantity());
        sell1.setBeego(sell2.getBeego());
        sell1.setUserName(sell2.getUserName());
        return sell1;
    }

    public static SellDetail of(SellDetailRequestDto sellDetailRequestDto) {
        return builder()
                .id(sellDetailRequestDto.getId())
                .comCode(sellDetailRequestDto.getComCode())
                .sellId(sellDetailRequestDto.getSellId())
                .quantity(sellDetailRequestDto.getQuantity())
                .beego(sellDetailRequestDto.getBeego())
                .userName(sellDetailRequestDto.getUserName())
                .build();
    }

    public static SellDetail of(SellDetailResponseDto sellDetailResponseDto) {
        return builder()
                .id(sellDetailResponseDto.getId())
                .comCode(sellDetailResponseDto.getComCode())
                .sellId(sellDetailResponseDto.getSellId())
                .quantity(sellDetailResponseDto.getQuantity())
                .beego(sellDetailResponseDto.getBeego())
                .userName(sellDetailResponseDto.getUserName())
                .build();
    }
}
