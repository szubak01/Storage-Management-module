package com.example.storagemanagement.domain.product.request;

import com.example.storagemanagement.domain.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductResponse {

    public Product map(ProductRequest request){

        return Product.builder()
                .name(request.getName())
                .build();

    }
}
