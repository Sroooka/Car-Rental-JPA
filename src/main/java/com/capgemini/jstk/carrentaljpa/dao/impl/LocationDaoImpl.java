package com.capgemini.jstk.carrentaljpa.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.carrentaljpa.dao.LocationDao;
import com.capgemini.jstk.carrentaljpa.domain.LocationEntity;

@Repository
public class LocationDaoImpl extends AbstractDao<LocationEntity, Long> implements LocationDao{

}
