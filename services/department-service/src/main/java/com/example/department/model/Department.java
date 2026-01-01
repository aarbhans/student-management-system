package com.example.department.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String departmentCode;

    @Column(unique = true, nullable = false)
    private String departmentName;

    private String headOfDepartment;

    private String description;

    public Department(String departmentCode, String departmentName, String headOfDepartment, String description) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.headOfDepartment = headOfDepartment;
        this.description = description;
    }
}
