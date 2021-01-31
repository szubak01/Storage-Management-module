package com.example.storagemanagement.service;


import com.example.storagemanagement.domain.assignment.Assignment;
import com.example.storagemanagement.domain.assignment.request.AssignmentRequest;
import com.example.storagemanagement.domain.assignment.request.AssignmentResponse;
import com.example.storagemanagement.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {


    private final AssignmentRepository assignmentRepository;
    private final AssignmentResponse assignmentResponse;

    public AssignmentService(AssignmentRepository assignmentRepository, AssignmentResponse assignmentResponse){
        this.assignmentRepository = assignmentRepository;
        this.assignmentResponse = assignmentResponse;
    }


    public Assignment saveAssignment(AssignmentRequest request){
        return assignmentRepository.save(assignmentResponse.map(request));
    }

    public List<Assignment> getAssignments(){
        return assignmentRepository.findAll();
    }


    public Assignment getAssignmentById(Long id){

        return assignmentRepository.findById(id).orElse(null);
    }


    public String deleteAssignment(Long id){
        assignmentRepository.deleteById(id);
        return "Assignment with ID: " + id + "removed.";
    }


    public Assignment updateAssignment(AssignmentRequest request, Long id) {
        return assignmentRepository.findById(id)
                .map(assignment -> editAssignment(assignment, request))
                .orElse(null);
    }

    private Assignment editAssignment(Assignment assignment, AssignmentRequest request) {
        Assignment newAssignment = assignmentResponse.map(request);
        newAssignment.setId(assignment.getId());
        return assignmentRepository.save(newAssignment);
    }

}
