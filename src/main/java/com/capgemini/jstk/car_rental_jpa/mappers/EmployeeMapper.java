package com.capgemini.jstk.car_rental_jpa.mappers;

import java.util.Set;
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
		employeeEntity.setId(employeeTO.getId());
		employeeEntity.setName(employeeTO.getName());
		employeeEntity.setSurname(employeeTO.getSurname());
		employeeEntity.setPosition(employeeTO.getPosition());
		return employeeEntity;
	}
	
	public static Set<EmployeeTO> map2TOs(Set<EmployeeEntity> employeeEntities) {
		return employeeEntities.stream().map(EmployeeMapper::toEmployeeTO).collect(Collectors.toSet());
	}
	
	public static Set<EmployeeEntity> map2Entities(Set<EmployeeTO> employeeTO) {
		return employeeTO.stream().map(EmployeeMapper::toEmployeeEntity).collect(Collectors.toSet());
	}
}
