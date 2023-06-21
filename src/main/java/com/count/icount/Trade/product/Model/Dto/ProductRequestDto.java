package com.count.icount.trade.product.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDto {
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
}