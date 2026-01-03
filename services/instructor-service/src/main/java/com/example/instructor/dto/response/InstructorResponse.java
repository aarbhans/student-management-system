package com.example.instructor.dto.response;

import lombok.Data;

import java.time.LocalDate;


@Data
public class InstructorResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String specialization;
    private Long departmentId;
    private LocalDate hireDate;
}
