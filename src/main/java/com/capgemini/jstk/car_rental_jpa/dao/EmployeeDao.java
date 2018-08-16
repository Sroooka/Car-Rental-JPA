package com.capgemini.jstk.car_rental_jpa.dao;

import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.domain.EmployeeEntity;


public interface EmployeeDao extends Dao<EmployeeEntity, Long>{
	public void addCarer(Long employeeId, CarEntity car);
}
