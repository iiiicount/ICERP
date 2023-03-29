package com.count.icount.Trade.product.Controller;


import com.count.icount.Trade.product.Model.Dto.ProductRequestDto;
import com.count.icount.Trade.product.Model.Dto.ProductResponseDto;
import com.count.icount.Trade.product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public ResponseEntity<ProductResponseDto> saveProduct(@RequestBody ProductRequestDto product){
        //System.out.printf("product = { name=%s, p_price=%s, s_price=%s }%n", product.getName(), product.getPurchasePrice(), product.getSellPrice());
        return ResponseEntity.ok(productService.saveProduct(product));
    }

}
