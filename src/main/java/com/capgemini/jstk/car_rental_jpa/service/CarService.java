package com.capgemini.jstk.car_rental_jpa.service;

import java.util.List;

import com.capgemini.jstk.car_rental_jpa.types.CarTO;
import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.enums.CarType;

public interface CarService {
	public CarTO findCarById(Long id);
	public CarEntity findCarEntityById(Long id);
	public List<CarTO> findAllCars();
	public List<CarTO> findCarByManufacturer(String manufacturer);
	public List<CarTO> findCarByModel(String model);
	public List<CarTO> findCarByProductionYear(int productionYear);
	public List<CarTO> findCarByCarType(CarType carType);
	public CarTO updateCar(CarTO newCar);
	public boolean contains(Long id);
	public CarTO deleteCar(Long id);
	public CarTO saveCar(CarTO car);
	public CarEntity saveEntityCar(CarEntity car);
	public void clear();
}
