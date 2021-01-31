package com.example.storagemanagement.controller;


import com.example.storagemanagement.domain.assignment.Assignment;
import com.example.storagemanagement.domain.assignment.request.AssignmentRequest;
import com.example.storagemanagement.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin
public class AssignmentController {

    @Autowired
    private final AssignmentService service;

    private List<Assignment> assignmentList;

    @GetMapping("api/assignments/nip")
    public List<Assignment> findAssignmentByNip(@RequestParam Long nip){
        assignmentList = service.getAssignments();
        Predicate<Assignment> byNip = assignmentList -> assignmentList.getContractor().getNip().equals(nip);

        List<Assignment> foundByNip = assignmentList
                .stream()
                .filter(byNip)
                .collect(Collectors.toList());

        return foundByNip;
    }
    

    @GetMapping("/api/assignments")
    public List<Assignment> findAllAssignments() {
        return service.getAssignments();
    }

    @GetMapping("/api/assignments/{id}")
    public Assignment findAssignmentById(@PathVariable Long id) {
        return service.getAssignmentById(id);
    }

    @PostMapping("/api/assignments")
    public Assignment addAssignment(@RequestBody AssignmentRequest request) {
        return service.saveAssignment(request);
    }

    @PutMapping("/api/assignments/{id}")
    public Assignment updateAssignment(@RequestBody AssignmentRequest request, @PathVariable Long id) {
        return service.updateAssignment(request, id);
    }

    @DeleteMapping("/api/assignments/delete/{id}")
    public String deleteAssignment(@PathVariable Long id) {
        return service.deleteAssignment(id);
    }

}
