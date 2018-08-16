package com.capgemini.jstk.car_rental_jpa.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.car_rental_jpa.dao.EmployeeDao;
import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.domain.EmployeeEntity;
import com.capgemini.jstk.car_rental_jpa.mappers.CarMapper;
import com.capgemini.jstk.car_rental_jpa.mappers.EmployeeMapper;
import com.capgemini.jstk.car_rental_jpa.service.EmployeeService;
import com.capgemini.jstk.car_rental_jpa.types.CarTO;
import com.capgemini.jstk.car_rental_jpa.types.EmployeeTO;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeRepository;
	
	@Override
	@Transactional(readOnly = false)
	public EmployeeTO saveEmployee(EmployeeTO employee) {
		EmployeeEntity employeeEntity = employeeRepository.save(EmployeeMapper.toEmployeeEntity(employee));
		return EmployeeMapper.toEmployeeTO(employeeEntity);
	}
	
	@Override
	public List<EmployeeTO> findAllEmployees() {
		List<EmployeeEntity> allEmployees = employeeRepository.findAll();
		return EmployeeMapper.map2TOs(allEmployees);
	}
	
	@Override
	public boolean contains(Long id){
		return employeeRepository.exists(id);
	}
	
	@Override
	public EmployeeTO findEmployeeById(Long id) {
		if(employeeRepository.exists(id)){
			return EmployeeMapper.toEmployeeTO(employeeRepository.getOne(id));
		}
		return null;
	}

	@Override
	public EmployeeEntity findEmployeeEntityById(Long id) {
		if(employeeRepository.exists(id)){
			return employeeRepository.getOne(id);
		}
		return null;
	}

	@Override
	public void addCarer(Long employeeId, CarEntity car) {
		EmployeeEntity employee = this.findEmployeeEntityById(employeeId);
		Collection<CarEntity> cars = employee.getCars();
		cars.add(car);
	}
}
