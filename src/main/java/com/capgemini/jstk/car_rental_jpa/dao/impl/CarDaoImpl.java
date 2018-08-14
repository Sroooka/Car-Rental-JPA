package com.capgemini.jstk.car_rental_jpa.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.car_rental_jpa.dao.CarDao;
import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao{
	
}