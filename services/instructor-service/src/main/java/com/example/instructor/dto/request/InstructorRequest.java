package com.example.instructor.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InstructorRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String specialization;
    private Long departmentId;
    private LocalDate hireDate;
}
