package com.count.icount.Trade.product.Model.Dto;

import com.count.icount.Trade.product.Model.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// ??
public class ProductRequestDto {
    private Long id;

    public Product toEntity() {
        return Product.builder()
                .id(id)
                .build();
    }
}
