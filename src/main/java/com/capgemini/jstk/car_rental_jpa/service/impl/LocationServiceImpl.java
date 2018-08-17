package com.capgemini.jstk.car_rental_jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.car_rental_jpa.dao.LocationDao;
import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.domain.LocationEntity;
import com.capgemini.jstk.car_rental_jpa.mappers.CarMapper;
import com.capgemini.jstk.car_rental_jpa.mappers.LocationMapper;
import com.capgemini.jstk.car_rental_jpa.service.LocationService;
import com.capgemini.jstk.car_rental_jpa.types.CarTO;
import com.capgemini.jstk.car_rental_jpa.types.LocationTO;

@Service
@Transactional(readOnly = true)
public class LocationServiceImpl implements LocationService{
	@Autowired
	private LocationDao locationRepository;
	
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
}
