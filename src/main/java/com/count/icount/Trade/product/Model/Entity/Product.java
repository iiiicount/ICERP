package com.count.icount.Trade.product.Model.Entity;

import com.count.icount.Trade.product.Model.Dto.ProductRequestDto;
import com.count.icount.company.Model.Entity.Company;
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
    @ManyToOne
    @JoinColumn(name="comCode", nullable = false)
    private Company company;
    @Column(nullable = false, length = 20)
    private String code;
    @Column(nullable = false)
    private String name;
    @Column(length = 100)
    private String standard;
    @Column(length = 100)
    private String unit;
    @Column(columnDefinition = "char(1) default 'Y'")
    private char taxation;
    @Column
    private float purchasePrice;
    @Column
    private float sellPrice;
    @Column(columnDefinition = "char(1) default 'Y'")
    private char status;
    @Column(length = 500)
    private String memo;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp enrollDt;
    @UpdateTimestamp
    @Column
    private Timestamp updateDt;

    public static Product of(ProductRequestDto product, Company company){
        return Product.builder()
                .id(product.getId())
                .company(company)
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