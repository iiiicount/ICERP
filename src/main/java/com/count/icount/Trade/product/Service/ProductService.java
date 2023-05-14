package com.count.icount.Trade.product.Service;

import com.count.icount.Trade.product.Model.Dto.ProductRequestDto;
import com.count.icount.Trade.product.Model.Dto.ProductResponseDto;
import com.count.icount.Trade.product.Model.Dto.GetProductResponseDto;
import com.count.icount.Trade.product.Model.Entity.Product;
import com.count.icount.Trade.product.Repository.ProductRepository;
import com.count.icount.company.Model.Entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * [TODO]
 * - save시 Company 검증과정 개선
 * */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductResponseDto saveProduct(String comCode, ProductRequestDto product){
        var company = validateCompany(comCode);
        Product newProduct = Product.of(product, company);
        return ProductResponseDto.of(productRepository.save(newProduct));
    }
    @Transactional
    public List<ProductResponseDto> saveProducts(String comCode, List<ProductRequestDto> products) {
        var company = validateCompany(comCode);
        var newProducts = Product.of(products, company);
        return ProductResponseDto.of(productRepository.saveAll(newProducts));
    }

    @Transactional(readOnly = true)
    public List<GetProductResponseDto> getProducts(String comCode, Pageable page) {
        List<GetProductResponseDto> result = new ArrayList<>();
        var products = productRepository.findAllByCompany_ComCode(comCode, page);

        if(products.size() > 0) {
            for(var product : products) {
                var response = GetProductResponseDto.of(product);
                result.add(response);
            }
        }
        return result;
    }

    private Company validateCompany(String comCode) {
        // 임시코드. 수정필요.
        Company company = new Company();
        company.setComCode(comCode);

        return company;
    }
}
