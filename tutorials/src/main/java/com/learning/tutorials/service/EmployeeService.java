package com.learning.tutorials.service;

import com.learning.tutorials.dto.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    ResponseEntity<List<Employee>> getAllEmployee();
}
