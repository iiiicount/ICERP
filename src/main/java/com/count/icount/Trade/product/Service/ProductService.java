package com.count.icount.Trade.product.Service;

import com.count.icount.Trade.product.Model.Dto.ProductRequestDto;
import com.count.icount.Trade.product.Model.Dto.ProductResponseDto;
import com.count.icount.Trade.product.Model.Entity.Product;
import com.count.icount.Trade.product.Repository.ProductRepository;
import com.count.icount.company.Model.Entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto saveProduct(ProductRequestDto product){
        // 이 과정 반복될거같으니까 고민해보기
        Company company = new Company();
        company.setComCode(product.getComCode());

        Product newProduct = Product.of(product, company);
        return ProductResponseDto.of(productRepository.save(newProduct));
    }
}
