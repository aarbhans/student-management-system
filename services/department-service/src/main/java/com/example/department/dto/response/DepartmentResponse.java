package com.example.department.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentResponse {
    private Long id;
    private String departmentCode;
    private String departmentName;
    private String headOfDepartment;
    private String description;
}
