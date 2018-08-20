package com.capgemini.jstk.car_rental_jpa.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.car_rental_jpa.dao.RentalDao;
import com.capgemini.jstk.car_rental_jpa.domain.RentalEntity;

@Repository
public class RentalDaoImpl extends AbstractDao<RentalEntity, Long> implements RentalDao{

}
