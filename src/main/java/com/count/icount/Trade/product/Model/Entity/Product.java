package com.count.icount.Trade.product.Model.Entity;

import com.count.icount.Trade.product.Model.Dto.ProductRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String standard;
    @Column
    private String unit;
    @Column
    private char taxation = 'Y';
    @Column
    private float purchasePrice;
    @Column
    private float sellPrice;
    @Column
    private char status = 'Y';
    @Column
    private String memo;
    @Column
    private Timestamp enrollDate = new Timestamp(System.currentTimeMillis());

    public static Product of(ProductRequestDto product){
        return Product.builder()
                .id(product.getId())
                .name(product.getName())
                .standard(product.getStandard())
                .unit(product.getUnit())
                .taxation(product.getTaxation())
                .purchasePrice(product.getPurchasePrice())
                .sellPrice(product.getSellPrice())
                .status(product.getStatus())
                .memo(product.getMemo())
                .enrollDate(product.getEnrollDate())
                .build();
    }
}