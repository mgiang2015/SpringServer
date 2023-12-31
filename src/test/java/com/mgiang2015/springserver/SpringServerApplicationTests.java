package com.mgiang2015.springserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mgiang2015.springserver.model.employee.Employee;
import com.mgiang2015.springserver.model.employee.EmployeeDao;

@SpringBootTest
class SpringServerApplicationTests {

	@Autowired
	EmployeeDao employeeDao;

	@Test
	void contextLoads() {
	}

	@Test
	void addEmployeeTest() {
		Employee employee = new Employee();
		employee.setName("Le");
		employee.setBranch("Dance");
		employee.setLocation("NUS");
		employeeDao.save(employee);
	}

}
