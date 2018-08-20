package com.capgemini.jstk.carrentaljpa.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.carrentaljpa.dao.CarDao;
import com.capgemini.jstk.carrentaljpa.dao.EmployeeDao;
import com.capgemini.jstk.carrentaljpa.dao.LocationDao;
import com.capgemini.jstk.carrentaljpa.domain.EmployeeEntity;
import com.capgemini.jstk.carrentaljpa.domain.LocationEntity;
import com.capgemini.jstk.carrentaljpa.mappers.EmployeeMapper;
import com.capgemini.jstk.carrentaljpa.mappers.LocationMapper;
import com.capgemini.jstk.carrentaljpa.service.LocationService;
import com.capgemini.jstk.carrentaljpa.types.EmployeeTO;
import com.capgemini.jstk.carrentaljpa.types.LocationTO;

@Service
@Transactional(readOnly = true)
public class LocationServiceImpl implements LocationService{
	@Autowired
	private LocationDao locationRepository;
	
	@Autowired
	private EmployeeDao employeeRepository;
	
	@Autowired 
	private CarDao carRepository;
	
	@Transactional(readOnly = false)
	@Override
	public LocationTO saveLocation(LocationTO location) {
		LocationEntity locationEntity = locationRepository.save(LocationMapper.toLocationEntity(location));
		return LocationMapper.toLocationTO(locationEntity);
	}
	
	@Override
	public LocationTO findLocationById(Long id) {
		if(locationRepository.exists(id)){
			return LocationMapper.toLocationTO(locationRepository.getOne(id));
		}
		return null;
	}
	
	@Override
	public LocationEntity findLocationEntityById(Long id) {
		if(locationRepository.exists(id)){
			return locationRepository.getOne(id);
		}
		return null;
	}
	
	@Transactional(readOnly = false)
	@Override
	public LocationTO deleteLocation(Long id) {
		if(!locationRepository.exists(id)){
			return null;
		}
		LocationTO location = LocationMapper.toLocationTO(locationRepository.getOne(id));
		locationRepository.delete(id);
		return location;
	}
	
	@Override
	public boolean contains(Long id){
		return locationRepository.exists(id);
	}
	
	@Transactional(readOnly = false)
	@Override
	public LocationTO updateLocation(LocationTO updatedLocation) {
		if(!locationRepository.exists(updatedLocation.getId())){
			return null;
		}
		LocationEntity locationEntity = findLocationEntityById(updatedLocation.getId());
		locationEntity.setAddress(updatedLocation.getAddress());
		locationEntity.setCity(updatedLocation.getCity());
		locationEntity.setEmail(updatedLocation.getEmail());
		locationEntity.setPhone(updatedLocation.getPhone());
		locationEntity.setPostalCode(updatedLocation.getPostalCode());
		return LocationMapper.toLocationTO(locationRepository.update(locationEntity));
	}
	
	@Transactional(readOnly = false)
	@Override
	public boolean addEmployeeToLocation(Long locationId, Long employeeId){
		if(!(employeeRepository.exists(employeeId) && locationRepository.exists(locationId))){
			return false;
		}	
		LocationEntity location = locationRepository.findOne(locationId);
		EmployeeEntity employee = employeeRepository.findOne(employeeId);
		location.getEmployee().add(employee);
		employee.setLocation(location);
		locationRepository.update(location);
		employeeRepository.update(employee);
		return true;
	}
	
	@Transactional(readOnly = false)
	@Override
	public boolean deleteEmployeeFromLocation(Long locationId, Long employeeId){
		if(!(employeeRepository.exists(employeeId) && locationRepository.exists(locationId))){
			return false;
		}	
		LocationEntity location = locationRepository.findOne(locationId);
		EmployeeEntity employee = employeeRepository.findOne(employeeId);
		boolean isRemoved = location.getEmployee().remove(employee);
		if (isRemoved) {
			employee.setLocation(null);
		}
		locationRepository.update(location);
		employeeRepository.update(employee);
		return isRemoved;
	}
	
	public List<EmployeeTO> findEmployeesByLocationId(Long locationId){
		if(!locationRepository.exists(locationId)){
			return null;
		}
		Set<EmployeeEntity> employeeList = locationRepository.findOne(locationId).getEmployee();
		return employeeList.stream().map(EmployeeMapper::toEmployeeTO).collect(Collectors.toList());
	}
	
	public List<EmployeeTO> findEmployeesByLocationWhoCaresCar(Long locationId, Long carId){
		if(!(carRepository.exists(carId) && locationRepository.exists(locationId))){
			return null;
		}
		Set<EmployeeEntity> employeeList = locationRepository.findOne(locationId).getEmployee();
		return employeeList.stream().filter(x -> x.getCars().contains(carRepository.getOne(carId))).map(EmployeeMapper::toEmployeeTO).collect(Collectors.toList());
	}
}
