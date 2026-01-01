package com.example.department.controller;

import com.example.department.dto.request.DepartmentRequest;
import com.example.department.dto.response.DepartmentResponse;
import com.example.department.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // Create a department
    @PostMapping
    public ResponseEntity<DepartmentResponse> createDepartment(@Valid @RequestBody DepartmentRequest departmentRequest) {
        DepartmentResponse response = departmentService.createDepartment(departmentRequest);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping
    public List<DepartmentResponse> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentResponse getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDepartment(@PathVariable Long id, @Valid @RequestBody DepartmentRequest departmentRequest) {
        departmentService.updateDepartment(id, departmentRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
