package com.genuinecoder.springserver.model.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service // Service defines how the logic of operations are carried out. Implementation of interface basically.
public class EmployeeDao {  // DAO: Data Access Object. Essentially object that access data...
    
    @Autowired
    private EmployeeRepository repository; // Dependency Injection! Automatically gives you an object, autowire helps you use internal implementation

    // Logic for C
    // We want to return object because we want to provide a helpful response along with HTTP response code
    public Employee save(Employee employee) {
        // Done, implementation provided by repository. SHEEEEESH
        return repository.save(employee);
    }

    // Logic for R
    public List<Employee> getAllEmployees() {
        // return repository.findAll(); -> returns an iterable. We don't want that, we want a LIST
        return Streamable.of(repository.findAll()).toList();
    }

    // Logic for D
    public void delete(Employee employee) {
        // Done, implementation provided by repository. SHEEEEESH
        repository.delete(employee);
    }
}
