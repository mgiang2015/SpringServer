package com.genuinecoder.springserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.genuinecoder.springserver.model.employee.Employee;
import com.genuinecoder.springserver.model.employee.EmployeeDao;

import java.util.List;

@RestController // considered as REST API controller. GET and POST requests automatically handled by Springboot
public class EmployeeController {

    @Autowired // inject DAO object into controller
    private EmployeeDao employeeDao;

    @GetMapping("/employee/get-all") // tag for define a GET endpoint
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @PostMapping("/employee/save") 
    public void save(@RequestBody Employee employee) {  // Employee object will be parsed into an object automatically
        employeeDao.save((employee));
    }
}
