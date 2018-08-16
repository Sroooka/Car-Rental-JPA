package com.capgemini.jstk.car_rental_jpa.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.car_rental_jpa.dao.CarDao;
import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.enums.CarType;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao{

	@Override
	public List<CarEntity> findCarsByManufacturer(String manufacturer) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where upper(car.manufacturer) like concat(upper(:manufacturer), '%')", CarEntity.class);
        query.setParameter("manufacturer", manufacturer);
        return query.getResultList();
	}

	@Override
	public List<CarEntity> findCarsByModel(String model) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where upper(car.model) like concat(upper(:model), '%')", CarEntity.class);
        query.setParameter("model", model);
        return query.getResultList();
	}

	@Override
	public List<CarEntity> findCarsByProductionYear(int productionYear) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where car.productionYear = :productionYear", CarEntity.class);
        query.setParameter("productionYear", productionYear);
        return query.getResultList();
	}

	@Override
	public List<CarEntity> findCarsByCarType(CarType carType) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where car.carType = :carType", CarEntity.class);
        query.setParameter("carType", carType);
        return query.getResultList();
	}

	@Override
	public List<CarEntity> findCarsByColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarEntity> findCarsByEngineSize(int engineSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarEntity> findCarsByPower(int power) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarEntity> findCarsByMileage(int mileage) {
		// TODO Auto-generated method stub
		return null;
	}
}