package com.example.instructor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;


    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String specialization;

    private Long departmentId;

    private LocalDate hireDate;
}
