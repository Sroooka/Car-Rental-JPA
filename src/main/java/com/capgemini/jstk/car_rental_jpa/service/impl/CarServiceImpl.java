package com.capgemini.jstk.car_rental_jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.car_rental_jpa.dao.CarDao;
import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.mappers.CarMapper;
import com.capgemini.jstk.car_rental_jpa.service.CarService;
import com.capgemini.jstk.car_rental_jpa.types.CarTO;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService{
	@Autowired
	private CarDao carRepository;

	@Override
	public List<CarTO> findAllCars() {
		List<CarEntity> allCars = carRepository.findAll();
		return CarMapper.map2TOs(allCars);
	}
	
	@Override
	public List<CarTO> findCarByManufacturer(String manufacturer) {
		List<CarEntity> allCars = carRepository.findCarsByManufacturer(manufacturer);
		return CarMapper.map2TOs(allCars);
	}
	
	@Override
	@Transactional(readOnly = false)
	public CarTO saveCar(CarTO car) {
		CarEntity carEntity = carRepository.save(CarMapper.toCarEntity(car));
		return CarMapper.toCarTO(carEntity);
	}
}
