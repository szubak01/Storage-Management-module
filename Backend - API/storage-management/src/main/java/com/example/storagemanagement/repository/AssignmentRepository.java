package com.example.storagemanagement.repository;

import com.example.storagemanagement.domain.assignment.Assignment;
import com.example.storagemanagement.domain.contractor.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}
