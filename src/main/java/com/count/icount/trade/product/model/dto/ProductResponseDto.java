package com.count.icount.trade.product.model.dto;

import com.count.icount.trade.product.model.entity.Product;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// enroll product request dto
public class ProductResponseDto {
    private Long id;
    private String comCode;
    private String code;
    private String name;
    private Timestamp enrollDt;
    private Timestamp updateDt;

    public static ProductResponseDto of(Product product){
        return ProductResponseDto.builder()
                .id(product.getId())
                .comCode(product.getCompany().getComCode())
                .code(product.getCode())
                .name(product.getName())
                .enrollDt(product.getEnrollDt())
                .updateDt(product.getUpdateDt())
                .build();
    }

    public static List<ProductResponseDto> of(List<Product> products) {
        return products.stream()
                .map(p -> ProductResponseDto.of(p))
                .collect(Collectors.toList());
    }
}
