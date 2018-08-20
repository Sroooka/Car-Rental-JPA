package com.capgemini.jstk.car_rental_jpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.car_rental_jpa.criterias.EmployeeSearchCriteria;
import com.capgemini.jstk.car_rental_jpa.criterias.EmployeeSearchCriteria.EmployeeSearchCriteriaBuilder;
import com.capgemini.jstk.car_rental_jpa.enums.Position;
import com.capgemini.jstk.car_rental_jpa.types.CustomerTO;
import com.capgemini.jstk.car_rental_jpa.types.EmployeeTO;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest (properties = "spring.profiles.active=mysql-test")
//@SpringBootTest (properties = "spring.profiles.active=hsql-test")
public class EmployeeServiceTest {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired 
	LocationService locationService;
	
	@Autowired
	CarService carService;
	
	@Test
	public void shouldSaveEmployee() {
		// given
		EmployeeTO employee = employeeService.saveEmployee(getEmployee());
		// when

		EmployeeTO foundEmployee = employeeService.findEmployeeById(employee.getId());
		// then
		assertNotNull(foundEmployee);
		assertEquals(foundEmployee.getName(), "Jan");
		assertEquals(foundEmployee.getSurname(), "Kowalski");
		assertEquals(foundEmployee.getPosition(), Position.MANAGER);
	}
	
	public void shouldFindEmployeeByCriteria(){
		// given
		
		// when

		// then
	}
	
	private EmployeeTO getEmployee(){
		EmployeeTO employee = new EmployeeTO();
		employee.setName("Jan");
		employee.setSurname("Kowalski");
		employee.setPosition(Position.MANAGER);
		return employee;
	}
}
