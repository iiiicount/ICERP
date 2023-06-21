package com.count.icount.trade.product.Controller;


import com.count.icount.trade.product.Model.Dto.GetProductResponseDto;
import com.count.icount.trade.product.Model.Dto.ProductRequestDto;
import com.count.icount.trade.product.Model.Dto.ProductResponseDto;
import com.count.icount.trade.product.Service.ProductService;
import com.count.icount.annotation.AuthInfo;
import com.count.icount.model.AuthUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<List<ProductResponseDto>> saveProducts(@AuthInfo AuthUserInfo auth,
                                                                 @RequestBody List<ProductRequestDto> products) {
        var result = productService.saveProducts(auth.getComCode(), products);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<GetProductResponseDto>> getCompanyProducts(@AuthInfo AuthUserInfo auth,
                                                                          @PageableDefault(size = 20, sort = {"enrollDt"}, direction = Sort.Direction.DESC) Pageable page) {
        var result = productService.getProducts(auth.getComCode(), page);
        return ResponseEntity.ok(result);
    }

}
