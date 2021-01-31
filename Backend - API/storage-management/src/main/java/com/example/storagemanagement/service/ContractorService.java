package com.example.storagemanagement.service;

import com.example.storagemanagement.domain.contractor.Contractor;
import com.example.storagemanagement.domain.contractor.request.ContractorRequest;
import com.example.storagemanagement.domain.contractor.request.ContractorResponse;
import com.example.storagemanagement.repository.ContractorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContractorService {

    private final ContractorRepository contractorRepository;
    private final ContractorResponse contractorResponse;

    private List<Contractor> contractors;

    public Contractor saveContractor(ContractorRequest request) {
        return contractorRepository.save(contractorResponse.map(request));
    }

    public List<Contractor> getContractors() {
        return contractorRepository.findAll();
    }

    public Contractor getContractorById(Long id) {
        return contractorRepository.findById(id).orElse(null);
    }


    public String deleteContractor(Long id) {
        contractorRepository.deleteById(id);
        return "Contractor with ID: " + id + "removed.";
    }

    public Contractor updateContractor(ContractorRequest request, Long id) {
        return contractorRepository.findById(id)
                .map(contractor -> editContractor(contractor, request))
                .orElse(null);
    }

    private Contractor editContractor(Contractor contractor, ContractorRequest request) {
        Contractor newContractor = contractorResponse.map(request);
        newContractor.setId(contractor.getId());
        return contractorRepository.save(newContractor);
    }
}
