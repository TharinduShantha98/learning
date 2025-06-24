package com.learning.tutorials.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employees")
public class EmployeeEntity {


    @Id
    @Column(name = "EmployeeID")
    private int employeeID;

    @Column(name = "FirstName", length = 50)
    private String firstName;

    @Column(name = "LastName", length = 50)
    private String lastName;

    @Column(name = "DepartmentID")
    private Integer departmentID;

    @Column(name = "Salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @Column(name = "JoinDate")
    private LocalDate joinDate;


}
