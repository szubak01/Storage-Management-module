package com.example.storagemanagement.domain.assignment.request;

import com.example.storagemanagement.domain.assignment.Assignment;
import com.example.storagemanagement.domain.contractor.Contractor;
import com.example.storagemanagement.domain.product.Product;
import com.example.storagemanagement.domain.storage.Storage;
import com.example.storagemanagement.infrastructure.NotFoundException;
import com.example.storagemanagement.repository.ContractorRepository;
import com.example.storagemanagement.repository.ProductRepository;
import com.example.storagemanagement.repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssignmentResponse {

    private final ProductRepository productRepository;
    private final ContractorRepository contractorRepository;
    private final StorageRepository storageRepository;

    public Assignment map(AssignmentRequest request) {
        return Assignment.builder()
                .quantity(request.getQuantity())
                .product(mapProduct(request.getProductId()))
                .contractor(mapContractor(request.getContractorId()))
                .storage(mapStorage(request.getStorageId()))
                .build();
    }

    private Product mapProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException(Product.class));
    }

    private Contractor mapContractor(Long contractorId) {
        return contractorRepository.findById(contractorId)
                .orElseThrow(() -> new NotFoundException(Contractor.class));
    }

    private Storage mapStorage(Long storageId) {
        return storageRepository.findById(storageId)
                .orElseThrow(() -> new NotFoundException(Storage.class));
    }
}
