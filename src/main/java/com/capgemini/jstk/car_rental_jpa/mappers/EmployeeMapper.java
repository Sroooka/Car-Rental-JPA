package com.capgemini.jstk.car_rental_jpa.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.jstk.car_rental_jpa.domain.EmployeeEntity;
import com.capgemini.jstk.car_rental_jpa.types.EmployeeTO;

public class EmployeeMapper {
	public static EmployeeTO toEmployeeTO(EmployeeEntity employeeEntity) {
		if (employeeEntity == null)
			return null;
		EmployeeTO employeeTO = new EmployeeTO();
		employeeTO.setId(employeeEntity.getId());
		employeeTO.setName(employeeEntity.getName());
		employeeTO.setSurname(employeeEntity.getSurname());
		employeeTO.setPosition(employeeEntity.getPosition());
		return employeeTO;
	}
	
	public static EmployeeEntity toEmployeeEntity(EmployeeTO employeeTO){
		if (employeeTO == null)
			return null;
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setName(employeeTO.getName());
		employeeEntity.setSurname(employeeTO.getSurname());
		employeeEntity.setPosition(employeeTO.getPosition());
		return employeeEntity;
	}
	
	public static List<EmployeeTO> map2TOs(List<EmployeeEntity> employeeEntities) {
		return employeeEntities.stream().map(EmployeeMapper::toEmployeeTO).collect(Collectors.toList());
	}
	
	public static List<EmployeeEntity> map2Entities(List<EmployeeTO> employeeTO) {
		return employeeTO.stream().map(EmployeeMapper::toEmployeeEntity).collect(Collectors.toList());
	}
}
