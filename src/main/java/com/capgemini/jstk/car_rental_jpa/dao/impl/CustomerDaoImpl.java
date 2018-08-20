package com.capgemini.jstk.car_rental_jpa.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.car_rental_jpa.dao.CustomerDao;
import com.capgemini.jstk.car_rental_jpa.domain.CustomerEntity;

@Repository
public class CustomerDaoImpl extends AbstractDao<CustomerEntity, Long> implements CustomerDao{

}
