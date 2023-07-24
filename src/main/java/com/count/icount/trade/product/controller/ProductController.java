package com.count.icount.trade.product.controller;

import com.count.icount.trade.product.model.dto.GetProductResponseDto;
import com.count.icount.trade.product.model.dto.ProductRequestDto;
import com.count.icount.trade.product.model.dto.ProductResponseDto;
import com.count.icount.trade.product.service.ProductService;
import com.count.icount.annotation.AuthInfo;
import com.count.icount.model.AuthUserInfo;
import com.count.icount.exception.CProductException;
import com.count.icount.exception.handler.ErrorCode;
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
            throw new CProductException("ID는 임의로 지정할 수 없습니다.", ErrorCode.WRONG_DATA);
        }

        var result = productService.saveProduct(auth.getComCode(), product);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetProductResponseDto> updateProduct(@AuthInfo AuthUserInfo auth,
                                                               @PathVariable("id") Long id,
                                                               @RequestBody ProductRequestDto product) {
        if(product.getCode() == null || product.getName() == null) {
            throw new CProductException("필수값이 누락되었습니다. (필수값: code, name)", ErrorCode.WRONG_DATA);
        }

        var result = productService.updateProduct(id, auth.getComCode(), product);
        if(result == null) {
            throw new CProductException("상품정보를 수정 할 수 없습니다.", ErrorCode.NOT_EXIST_TARGET);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDto> deleteProduct(@AuthInfo AuthUserInfo auth,
                                                            @PathVariable("id") Long id) {
        var result = productService.deleteProduct(auth.getComCode(), id);
        if(result == null) {
            throw new CProductException("상품정보를 삭제 할 수 없습니다.", ErrorCode.NOT_EXIST_TARGET);
        }
        return ResponseEntity.ok(result);
    }

}
