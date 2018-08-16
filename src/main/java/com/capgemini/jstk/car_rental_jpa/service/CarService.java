package com.capgemini.jstk.car_rental_jpa.service;

import java.util.List;

import com.capgemini.jstk.car_rental_jpa.types.CarTO;

public interface CarService {
	public List<CarTO> findAllCars();
	public List<CarTO> findCarByManufacturer(String manufacturer);
	
	public CarTO saveCar(CarTO car);
}
