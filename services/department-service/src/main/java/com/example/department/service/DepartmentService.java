package com.example.department.service;


import com.example.department.dto.request.DepartmentRequest;
import com.example.department.dto.response.DepartmentResponse;
import com.example.department.mapper.DepartmentMapper;
import com.example.department.model.Department;
import com.example.department.repository.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper mapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper mapper) {
        this.departmentRepository = departmentRepository;
        this.mapper = mapper;
    }

    public DepartmentResponse createDepartment(DepartmentRequest request) {
        Department department = mapper.toEntity(request);
        Department saved = departmentRepository.save(department);
        return mapper.toResponse(saved);
    }

    public List<DepartmentResponse> getDepartments() {
        List<Department> fetchedDepartments = departmentRepository.findAll();
        return fetchedDepartments.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public DepartmentResponse getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
        return mapper.toResponse(department);
    }

    @Transactional
    public void updateDepartment(Long id, DepartmentRequest request) {
        Department entity = departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));

        mapper.updateFromRequest(request, entity);
    }

    @Transactional
    public void deleteDepartment(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new EntityNotFoundException("Department not found with id: " + id);
        }
        departmentRepository.deleteById(id);
    }
}
