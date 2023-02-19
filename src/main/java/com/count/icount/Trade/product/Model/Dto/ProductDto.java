package com.count.icount.trade.product.Model.Dto;

import com.count.icount.trade.product.Model.Entity.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String name;

    public static ProductDto of(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .build();
    }
}
