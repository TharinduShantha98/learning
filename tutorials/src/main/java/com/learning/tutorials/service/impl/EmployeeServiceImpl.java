package com.learning.tutorials.service.impl;

import com.learning.tutorials.dto.Employee;
import com.learning.tutorials.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final ResourceLoader resourceLoader;

    @Autowired
    public EmployeeServiceImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    @Override
    public ResponseEntity<List<Employee>> getAllEmployee() {

        List<String> departments = List.of("IT", "HR", "FIN");
        String userImage;

        Resource resource = resourceLoader.getResource("classpath:images/" + "images.jpg");
        try (InputStream inputStream = resource.getInputStream()) {
            byte[] imageBytes = inputStream.readAllBytes();
            userImage =  Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Employee> collect = IntStream.rangeClosed(0, 1000)
                .mapToObj(i -> {
                    Employee emp = new Employee();
                    emp.setEId((long) i);
                    emp.setDepartment(departments.get(i % departments.size()));
                    emp.setImage(userImage);
                    return emp;
                }).toList();

        return ResponseEntity.ok(collect);


    }
}
