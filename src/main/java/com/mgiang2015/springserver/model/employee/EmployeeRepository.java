package com.mgiang2015.springserver.model.employee;

import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository // Denotes that this interface is a repository - operations permitted for **Employee** Entity with Primary key of type **Integer**
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    // this is all I need to do LOL, no need implementation. All comes out of the box with CrudRepository
}
