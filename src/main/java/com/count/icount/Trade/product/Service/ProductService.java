package com.count.icount.Trade.product.Service;

import com.count.icount.Trade.product.Model.Dto.ProductRequestDto;
import com.count.icount.Trade.product.Model.Dto.ProductResponseDto;
import com.count.icount.Trade.product.Model.Entity.Product;
import com.count.icount.Trade.product.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto saveProduct(ProductRequestDto product){
        Product newProduct = Product.of(product);
        return ProductResponseDto.of(productRepository.save(newProduct));
    }
}
