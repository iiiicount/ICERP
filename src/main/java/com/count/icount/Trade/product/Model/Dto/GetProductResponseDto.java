package com.count.icount.Trade.product.Model.Dto;

import com.count.icount.Trade.product.Model.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// enroll product request dto
public class GetProductResponseDto {
    private Long id;
    private String comCode;
    private String code;
    private String name;
    private String standard;
    private String unit;
    private char taxation;
    private float purchasePrice;
    private float sellPrice;
    private char status;
    private String memo;
    private Timestamp enrollDt;
    private Timestamp updateDt;
    public static GetProductResponseDto of(Product product){
        return GetProductResponseDto.builder()
                .id(product.getId())
                .comCode(product.getCompany().getComCode())
                .code(product.getCode())
                .name(product.getName())
                .standard(product.getStandard())
                .unit(product.getUnit())
                .taxation(product.getTaxation())
                .purchasePrice(product.getPurchasePrice())
                .sellPrice(product.getSellPrice())
                .status(product.getStatus())
                .memo(product.getMemo())
                .enrollDt(product.getEnrollDt())
                .updateDt(product.getUpdateDt())
                .build();
    }
}
