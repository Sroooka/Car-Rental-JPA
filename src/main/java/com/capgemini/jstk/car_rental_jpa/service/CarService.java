package com.capgemini.jstk.car_rental_jpa.service;

import java.util.Date;
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
	public List<CarTO> findCarByCarTypeAndManufacturer(CarType carType, String manufacturer);
	public boolean addCarer(Long carId, Long employeeId);
	public CarTO updateCar(CarTO newCar);
	public boolean contains(Long id);
	public CarTO deleteCar(Long id);
	public CarTO saveCar(CarTO car);
	public int length();
	public List<CarTO> findCarsByCarerID(Long carerId);
	public CarEntity saveEntityCar(CarEntity car);
	public void clear();
	public List<CarTO> findCarsRentedByMoreThanExpectedPeople(int i);
	public int findCarsAmountRentedInSpecifiedTime(Date from, Date to);
}
