package com.capgemini.jstk.carrentaljpa.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.carrentaljpa.criterias.EmployeeSearchCriteria;
import com.capgemini.jstk.carrentaljpa.dao.EmployeeDao;
import com.capgemini.jstk.carrentaljpa.domain.CarEntity;
import com.capgemini.jstk.carrentaljpa.domain.EmployeeEntity;
import com.capgemini.jstk.carrentaljpa.mappers.CarMapper;
import com.capgemini.jstk.carrentaljpa.mappers.EmployeeMapper;
import com.capgemini.jstk.carrentaljpa.service.EmployeeService;
import com.capgemini.jstk.carrentaljpa.types.CarTO;
import com.capgemini.jstk.carrentaljpa.types.EmployeeTO;

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
	public List<CarTO> getCaredCarsByEmployeeId(Long id) {
		if(employeeRepository.exists(id)){
			return CarMapper.map2TOs(employeeRepository.getOne(id).getCars().stream().collect(Collectors.toList()));
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

	@Override
	public List<EmployeeTO> searchByCriteria(EmployeeSearchCriteria criteria) {
		List<EmployeeTO> all = EmployeeMapper.map2TOs(employeeRepository.findAll());
		List<EmployeeTO> foundByLocation, foundByCaredCars, foundByPosition;
		foundByLocation = foundByCaredCars = foundByPosition = all;
		if(criteria.getLocation() != null){
			foundByLocation = EmployeeMapper.map2TOs(employeeRepository.searchByLocation(criteria.getLocation().getId()));
		}
		if(criteria.getCaredCar() != null){
			foundByCaredCars = EmployeeMapper.map2TOs(employeeRepository.searchByCaredCars(criteria.getCaredCar().getId()));
		}
		if(criteria.getPosition() != null){
			foundByPosition = EmployeeMapper.map2TOs(employeeRepository.searchByPosition(criteria.getPosition()));
		}
		all.retainAll(foundByLocation);
		all.retainAll(foundByCaredCars);
		all.retainAll(foundByPosition);
		return all;
	}
}
