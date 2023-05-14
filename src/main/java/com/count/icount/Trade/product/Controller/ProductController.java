package com.count.icount.Trade.product.Controller;


import com.count.icount.Trade.product.Model.Dto.ProductRequestDto;
import com.count.icount.Trade.product.Model.Dto.ProductResponseDto;
import com.count.icount.Trade.product.Service.ProductService;
import com.count.icount.annotation.AuthInfo;
import com.count.icount.annotation.AuthUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public ResponseEntity<ProductResponseDto> saveProduct(@AuthInfo AuthUserInfo auth,
                                                          @RequestBody ProductRequestDto product) {
        if (product.getId() != null) {
            return ResponseEntity.badRequest().build();
        }

        var result = productService.saveProduct(auth.getComCode(), product);
        return ResponseEntity.ok(result);
    }

}
