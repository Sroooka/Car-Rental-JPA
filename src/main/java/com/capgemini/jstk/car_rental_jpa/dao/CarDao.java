package com.capgemini.jstk.car_rental_jpa.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.domain.EmployeeEntity;
import com.capgemini.jstk.car_rental_jpa.enums.CarType;

public interface CarDao extends Dao<CarEntity, Long>{
	List<CarEntity> findCarsByManufacturer(String manufacturer);
	List<CarEntity> findCarsByModel(String model);
	List<CarEntity> findCarsByProductionYear(int productionYear);
	List<CarEntity> findCarsByCarType(CarType carType);
	List<CarEntity> findCarsByCarer(Long carerId);
	void addCarer(Long carId, EmployeeEntity carer);
	List<CarEntity> findCarByCarTypeAndManufacturer(CarType carType, String manufacturer);
	List<CarEntity> findCarsRentedByMoreThanExpectedPeople(int i);
	public int findCarsAmountRentedInSpecifiedTime(Date from, Date to);
}
