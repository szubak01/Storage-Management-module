package com.example.storagemanagement.controller;

import com.example.storagemanagement.domain.product.Product;
import com.example.storagemanagement.domain.product.request.ProductRequest;
import com.example.storagemanagement.repository.ProductRepository;
import com.example.storagemanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {


    private final ProductService service;
    private final ProductRepository productRepository;




    @GetMapping("/api/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }

    @PostMapping("/api/products")
    public Product addProduct(@RequestBody ProductRequest request){
        return service.saveProduct(request);
    }

    @GetMapping("/api/products/id/{id}")
    public Product findProductById(@PathVariable Long id){
        return service.getProductById(id);
    }

    @GetMapping("/api/products/name/{name}")
    public Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }


    @PutMapping("/api/products/{id}")
    public Product updateProduct(@RequestBody ProductRequest request, @PathVariable Long id){
        return service.updateProduct(request, id);
    }

    @DeleteMapping("/api/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        return service.deleteProduct(id);
    }


}

