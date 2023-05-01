package com.count.icount.Trade.product.Controller;


import com.count.icount.Trade.product.Model.Dto.ProductRequestDto;
import com.count.icount.Trade.product.Model.Dto.ProductResponseDto;
import com.count.icount.Trade.product.Model.Dto.GetProductResponseDto;
import com.count.icount.Trade.product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public ResponseEntity<ProductResponseDto> saveProduct(@RequestBody ProductRequestDto product) {
        if (product.getId() != null) {
            return ResponseEntity.badRequest().build();
        }

        var result = productService.saveProduct(product);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/com-code/{comCode}")
    public ResponseEntity<List<GetProductResponseDto>> getCompanyProducts(@PathVariable("comCode") Long comCode,
                                                                   @PageableDefault(size = 20, sort = {"enrollDt"}, direction = Sort.Direction.DESC) Pageable page) {
        var result = productService.getProducts(comCode, page);

        return ResponseEntity.ok(result);
    }

}
