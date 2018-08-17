package com.capgemini.jstk.car_rental_jpa.service;

import java.util.List;

import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.domain.EmployeeEntity;
import com.capgemini.jstk.car_rental_jpa.types.CarTO;
import com.capgemini.jstk.car_rental_jpa.types.EmployeeTO;

public interface EmployeeService {
	public EmployeeTO saveEmployee(EmployeeTO employee);
	public boolean contains(Long id);
	public EmployeeEntity findEmployeeEntityById(Long id);
	public EmployeeTO findEmployeeById(Long id);
	public void addCarer(Long employeeId, CarEntity car);
	public List<EmployeeTO> findAllEmployees();
	public List<CarTO> getCaredCarsByEmployeeId(Long id);
}
