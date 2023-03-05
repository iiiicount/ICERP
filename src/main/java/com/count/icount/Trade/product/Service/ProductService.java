package com.count.icount.Trade.product.Service;

import com.count.icount.Trade.product.Model.Dto.ProductDto;
import com.count.icount.Trade.product.Model.Entity.Product;
import com.count.icount.Trade.product.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDto saveProduct(ProductDto productInfo){
        Product newProduct = Product.of(productInfo);
        return ProductDto.of(productRepository.save(newProduct));

    }
}
