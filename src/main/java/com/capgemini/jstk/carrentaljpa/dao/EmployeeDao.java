package com.capgemini.jstk.carrentaljpa.dao;

import java.util.List;

import com.capgemini.jstk.carrentaljpa.domain.CarEntity;
import com.capgemini.jstk.carrentaljpa.domain.EmployeeEntity;
import com.capgemini.jstk.carrentaljpa.enums.Position;

public interface EmployeeDao extends Dao<EmployeeEntity, Long>{
	public void addCarer(Long employeeId, CarEntity car);
	
	public List<EmployeeEntity> searchByLocation(Long locationId);
	
	public List<EmployeeEntity> searchByCaredCars(Long id);
	
	public List<EmployeeEntity> searchByPosition(Position position);
}
