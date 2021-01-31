package com.example.storagemanagement.service;

import com.example.storagemanagement.domain.storage.Storage;
import com.example.storagemanagement.domain.storage.request.StorageRequest;
import com.example.storagemanagement.domain.storage.request.StorageResponse;
import com.example.storagemanagement.repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StorageService {


    private final StorageRepository storageRepository;
    private final StorageResponse storageResponse;

    public Storage saveStorage(StorageRequest request) {
        return storageRepository.save(storageResponse.map(request));
    }

    public List<Storage> getStorages() {
        return storageRepository.findAll();
    }

    public Storage getStorageById(Long id) {
        return storageRepository.findById(id).orElse(null);
    }

    public String deleteStorage(Long id) {
        storageRepository.deleteById(id);
        return "Storage with ID: " + id + "removed.";
    }

    public Storage updateStorage(StorageRequest request, Long id) {
        return storageRepository.findById(id)
                .map(storage -> editStorage(storage, request))
                .orElse(null);
    }

    private Storage editStorage(Storage storage, StorageRequest request) {
        Storage newStorage = storageResponse.map(request);
        newStorage.setId(storage.getId());
        return storageRepository.save(newStorage);
    }
}
