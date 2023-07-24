package com.count.icount.trade.product.model.entity;

import com.count.icount.trade.product.model.dto.ProductRequestDto;
import com.count.icount.company.model.entity.Company;
import com.count.icount.model.ICountChar;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name="com_code", nullable = false)
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
    @Builder.Default
    private char taxation = ICountChar.Y;
    @Column
    private float purchasePrice;
    @Column
    private float sellPrice;
    @Column(columnDefinition = "char(1) default 'Y'")
    @Builder.Default
    private char status = ICountChar.Y;
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
                .taxation(product.getTaxation() == ICountChar.DEFAULT ? ICountChar.Y : product.getTaxation())
                .purchasePrice(product.getPurchasePrice())
                .sellPrice(product.getSellPrice())
                .status(product.getStatus() == ICountChar.DEFAULT ? ICountChar.Y : product.getStatus())
                .memo(product.getMemo())
                .enrollDt(product.getEnrollDt())
                .updateDt(product.getUpdateDt())
                .build();
    }

    public static List<Product> of(List<ProductRequestDto> products, Company company) {
        List<Product> result = new ArrayList<>();
        products.forEach(product -> result.add(Product.of(product, company)));
        return result;
    }
}