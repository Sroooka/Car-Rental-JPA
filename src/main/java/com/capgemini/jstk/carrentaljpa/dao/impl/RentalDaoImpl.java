package com.capgemini.jstk.carrentaljpa.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.carrentaljpa.dao.RentalDao;
import com.capgemini.jstk.carrentaljpa.domain.RentalEntity;

@Repository
public class RentalDaoImpl extends AbstractDao<RentalEntity, Long> implements RentalDao{

}
