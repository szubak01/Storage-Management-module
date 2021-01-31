package com.example.storagemanagement.domain.assignment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentRequest {

    private Long productId;
    private Long contractorId;
    private Long storageId;
    private int quantity;
}
