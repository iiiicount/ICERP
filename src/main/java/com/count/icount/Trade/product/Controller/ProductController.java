package com.count.icount.Trade.product.Controller;


import com.count.icount.model.Dto.Response;
import com.count.icount.Trade.product.Model.Dto.ProductDto;
import com.count.icount.Trade.product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    @PostMapping
    public Response<ProductDto> saveProduct(@RequestBody ProductDto productInfo){
        System.out.println("hi");
        ProductDto newProductInfo = productService.saveProduct(productInfo);
        return new Response(newProductInfo);
    }
}
