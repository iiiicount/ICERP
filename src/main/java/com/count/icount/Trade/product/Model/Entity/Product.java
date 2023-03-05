package com.count.icount.Trade.product.Model.Entity;

import com.count.icount.Trade.product.Model.Dto.ProductDto;
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

    public static Product of(ProductDto productDto){
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .build();
    }
}