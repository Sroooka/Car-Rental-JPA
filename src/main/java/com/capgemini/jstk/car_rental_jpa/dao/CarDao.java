package com.capgemini.jstk.car_rental_jpa.dao;

import java.util.List;

import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.enums.CarType;

public interface CarDao extends Dao<CarEntity, Long>{
	List<CarEntity> findCarsByManufacturer(String manufacturer);
	List<CarEntity> findCarsByModel(String model);
	List<CarEntity> findCarsByProductionYear(int productionYear);
	List<CarEntity> findCarsByCarType(CarType carType);
	List<CarEntity> findCarsByColor(String color);
	List<CarEntity> findCarsByEngineSize(int engineSize);
	List<CarEntity> findCarsByPower(int power);
	List<CarEntity> findCarsByMileage(int mileage);
}
