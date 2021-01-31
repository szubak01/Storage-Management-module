package com.example.storagemanagement.controller;

import com.example.storagemanagement.domain.contractor.Contractor;
import com.example.storagemanagement.domain.contractor.request.ContractorRequest;
import com.example.storagemanagement.service.ContractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin
public class ContractorController {

    private final ContractorService contractorService;



    @PostMapping("/api/contractors")
    public Contractor addContractor(@RequestBody ContractorRequest request) {
        return contractorService.saveContractor(request);
    }

    @GetMapping("/api/contractors")
    public List<Contractor> findAllContractors() {
        return contractorService.getContractors();
    }

    @GetMapping("/api/contractors/{id}")
    public Contractor findContractorById(@PathVariable Long id) {
        return contractorService.getContractorById(id);
    }

    @PutMapping("/api/contractors/{id}")
    public Contractor updateContractor(@RequestBody ContractorRequest request, @PathVariable Long id) {
        return contractorService.updateContractor(request, id);
    }

    @DeleteMapping("/api/contractors/delete/{id}")
    public String deleteContractor(@PathVariable Long id) {
        return contractorService.deleteContractor(id);
    }

}