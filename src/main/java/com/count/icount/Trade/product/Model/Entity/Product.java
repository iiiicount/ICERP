package com.count.icount.Trade.product.Model.Entity;

import com.count.icount.Trade.product.Model.Dto.ProductRequestDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    @Column(nullable = false)
    private Long comCode;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String name;
    @Column
    private String standard;
    @Column
    private String unit;
    @Column(columnDefinition = "char(1) default 'Y'")
    private char taxation;
    @Column
    private float purchasePrice;
    @Column
    private float sellPrice;
    @Column(columnDefinition = "char(1) default 'Y'")
    private char status;
    @Column
    private String memo;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp enrollDt;
    @UpdateTimestamp
    @Column
    private Timestamp updateDt;

    public static Product of(ProductRequestDto product){
        return Product.builder()
                .id(product.getId())
                .comCode(product.getComCode())
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