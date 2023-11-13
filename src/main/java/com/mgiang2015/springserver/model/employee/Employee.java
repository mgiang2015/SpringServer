package com.genuinecoder.springserver.model.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // with @Entity tag, we define a schema with a Java class
@Table(name = "employees") // with @Table tag, a table is created automatically
public class Employee {
    @Id // With @Id tag, field below is automatically considered primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY automatically increments the value. Why is there an extra round bracket here?
    private int id;
    private String name;
    private String location;
    private String branch;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getBranch() {
        return branch;
    }
    
    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", location=" + location + ", branch=" + branch + "]";
    }

    
}
