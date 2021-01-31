package com.example.storagemanagement.service;

import com.example.storagemanagement.domain.product.Product;
import com.example.storagemanagement.domain.product.request.ProductRequest;
import com.example.storagemanagement.domain.product.request.ProductResponse;
import com.example.storagemanagement.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;
    private final ProductResponse productResponse;



    public Product saveProduct(ProductRequest request){
        return productRepository.save(productResponse.map(request));
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product with ID: " + id + "removed.";
    }


    public Product updateProduct(ProductRequest request, Long id) {
        return productRepository.findById(id)
                .map(product -> editProduct(product, request))
                .orElse(null);
    }

    private Product editProduct(Product product, ProductRequest request) {
        Product newProduct = productResponse.map(request);
        newProduct.setId(product.getId());
        return productRepository.save(newProduct);
    }

}
