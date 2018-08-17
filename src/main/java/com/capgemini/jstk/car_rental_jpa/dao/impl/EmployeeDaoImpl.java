package com.capgemini.jstk.car_rental_jpa.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.car_rental_jpa.dao.EmployeeDao;
import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.domain.EmployeeEntity;

@Repository
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDao{

	@Transactional(readOnly = false)
	@Override
	public void addCarer(Long employeeId, CarEntity car) {
		EmployeeEntity employee = this.findOne(employeeId);
		Collection<CarEntity> cars = employee.getCars();
		cars.add(car);
	}
}
