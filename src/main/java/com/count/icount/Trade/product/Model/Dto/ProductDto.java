package com.count.icount.Trade.product.Model.Dto;

import com.count.icount.Trade.product.Model.Entity.Product;
import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// enroll product request dto
public class ProductDto {
    private Long id;
    private String name;
    private String standard;
    private String unit;
    private char taxation;
    private float purchasePrice;
    private float sellPrice;
    private char status;
    private String memo;
    private Timestamp enrollDate;


    // ???
    public static ProductDto of(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .build();
    }

    public Product toEntity() {
        return Product.builder()
                .id(id)
                .name(name)
                .standard(standard)
                .unit(unit)
                .taxation(taxation)
                .purchasePrice(purchasePrice)
                .sellPrice(sellPrice)
                .status(status)
                .memo(memo)
                .enrollDate(enrollDate)
                .build();
    }
}
