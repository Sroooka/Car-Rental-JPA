package com.capgemini.jstk.car_rental_jpa.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.car_rental_jpa.dao.LocationDao;
import com.capgemini.jstk.car_rental_jpa.domain.LocationEntity;

@Repository
public class LocationDaoImpl extends AbstractDao<LocationEntity, Long> implements LocationDao{

}
