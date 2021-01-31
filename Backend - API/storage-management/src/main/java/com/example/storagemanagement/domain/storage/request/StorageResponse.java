package com.example.storagemanagement.domain.storage.request;

import com.example.storagemanagement.domain.storage.Storage;
import org.springframework.stereotype.Component;

@Component
public class StorageResponse {

    public Storage map(StorageRequest request) {
        return Storage.builder()
                .address(request.getAddress())
                .build();
    }
}
