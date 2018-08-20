package com.capgemini.jstk.car_rental_jpa.dao;

import java.util.List;

import com.capgemini.jstk.car_rental_jpa.criterias.EmployeeSearchCriteria;
import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.domain.EmployeeEntity;
import com.capgemini.jstk.car_rental_jpa.enums.Position;


public interface EmployeeDao extends Dao<EmployeeEntity, Long>{
	public void addCarer(Long employeeId, CarEntity car);
	public List<EmployeeEntity> searchByLocation(Long locationId);
	public List<EmployeeEntity> searchByCaredCars(Long id);
	public List<EmployeeEntity> searchByPosition(Position position);
}
