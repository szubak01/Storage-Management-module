package com.example.storagemanagement.repository;

import com.example.storagemanagement.domain.contractor.Contractor;
import com.example.storagemanagement.domain.storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
}
