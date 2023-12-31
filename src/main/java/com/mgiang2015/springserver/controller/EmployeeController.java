package com.mgiang2015.springserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgiang2015.springserver.model.employee.Employee;
import com.mgiang2015.springserver.model.employee.EmployeeDao;

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
    public Employee save(@RequestBody Employee employee) {  // Employee object will be parsed into an object automatically
        return employeeDao.save((employee));
    }
}
