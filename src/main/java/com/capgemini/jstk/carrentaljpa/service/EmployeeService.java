package com.capgemini.jstk.carrentaljpa.service;

import java.util.List;

import com.capgemini.jstk.carrentaljpa.criterias.EmployeeSearchCriteria;
import com.capgemini.jstk.carrentaljpa.domain.CarEntity;
import com.capgemini.jstk.carrentaljpa.domain.EmployeeEntity;
import com.capgemini.jstk.carrentaljpa.types.CarTO;
import com.capgemini.jstk.carrentaljpa.types.EmployeeTO;

public interface EmployeeService {
	public EmployeeTO saveEmployee(EmployeeTO employee);
	
	public boolean contains(Long id);
	
	public EmployeeEntity findEmployeeEntityById(Long id);
	
	public EmployeeTO findEmployeeById(Long id);
	
	public void addCarer(Long employeeId, CarEntity car);
	
	public List<EmployeeTO> findAllEmployees();
	
	public List<CarTO> getCaredCarsByEmployeeId(Long id);
	
	public List<EmployeeTO> searchByCriteria(EmployeeSearchCriteria criteria);
}
