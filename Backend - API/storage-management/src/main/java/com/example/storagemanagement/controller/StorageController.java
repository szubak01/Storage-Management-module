package com.example.storagemanagement.controller;


import com.example.storagemanagement.domain.product.Product;
import com.example.storagemanagement.domain.storage.Storage;
import com.example.storagemanagement.domain.storage.request.StorageRequest;
import com.example.storagemanagement.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin
public class StorageController {

    @Autowired
    private final StorageService service;






    @PostMapping("/api/storages")
    public Storage addStorage(@RequestBody StorageRequest request) {
        return service.saveStorage(request);
    }

    @GetMapping("/api/storages")
    public List<Storage> findAllStorages() {
        return service.getStorages();
    }

    @GetMapping("/api/storages/{id}")
    public Storage findStorageById(@PathVariable Long id) {
        return service.getStorageById(id);
    }

    @PutMapping("/api/storages/{id}")
    public Storage updateStorage(@RequestBody StorageRequest request, @PathVariable Long id) {
        return service.updateStorage(request, id);
    }

    @DeleteMapping("/api/storages/delete/{id}")
    public String deleteStorage(@PathVariable Long id) {
        return service.deleteStorage(id);
    }

}
