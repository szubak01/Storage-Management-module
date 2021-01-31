package com.example.storagemanagement.domain.contractor.request;

import com.example.storagemanagement.domain.contractor.Contractor;
import org.springframework.stereotype.Component;

@Component
public class ContractorResponse {

    public Contractor map(ContractorRequest request) {
        return Contractor.builder()
                .contractorName(request.getContractorName())
                .nip(request.getNip())
                .build();
    }
}
