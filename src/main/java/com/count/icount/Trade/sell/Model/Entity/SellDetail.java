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

    public static SellDetail of(SellDetailRequestDto sellDetailRequestDto) {
        return builder()
                .id(sellDetailRequestDto.getId())
                .comCode(sellDetailRequestDto.getComCode())
                .sellId(sellDetailRequestDto.getSellId())
                .quantity(sellDetailRequestDto.getQuantity())
                .beego(sellDetailRequestDto.getBeego())
                .build();
    }

    public static SellDetail of(SellDetailResponseDto sellDetailResponseDto) {
        return builder()
                .id(sellDetailResponseDto.getId())
                .comCode(sellDetailResponseDto.getComCode())
                .sellId(sellDetailResponseDto.getSellId())
                .quantity(sellDetailResponseDto.getQuantity())
                .beego(sellDetailResponseDto.getBeego())
                .build();
    }
}
