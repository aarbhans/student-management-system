package com.example.department.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DepartmentRequest {

    @NotBlank
    @Size(min = 2, max = 10)
    private String departmentCode;

    @NotBlank
    @Size(min = 2, max = 50)
    private String departmentName;

    @Size(max = 50)
    private String headOfDepartment;

    @Size(max = 50)
    private String description;
}
