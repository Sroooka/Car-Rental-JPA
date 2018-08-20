package com.capgemini.jstk.carrentaljpa.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.carrentaljpa.dao.CustomerDao;
import com.capgemini.jstk.carrentaljpa.domain.CustomerEntity;

@Repository
public class CustomerDaoImpl extends AbstractDao<CustomerEntity, Long> implements CustomerDao{

}
