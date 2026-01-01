package com.example.department.mapper;

import com.example.department.dto.request.DepartmentRequest;
import com.example.department.dto.response.DepartmentResponse;
import com.example.department.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toEntity(DepartmentRequest request);
    DepartmentResponse toResponse(Department department);
    void updateFromRequest(DepartmentRequest request,
                           @MappingTarget Department entity);
}
