package com.capgemini.jstk.carrentaljpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.carrentaljpa.dao.CustomerDao;
import com.capgemini.jstk.carrentaljpa.domain.CustomerEntity;
import com.capgemini.jstk.carrentaljpa.mappers.CustomerMapper;
import com.capgemini.jstk.carrentaljpa.service.CustomerService;
import com.capgemini.jstk.carrentaljpa.types.CustomerTO;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerRepository;
	
	@Transactional(readOnly = false)
	@Override
	public CustomerTO saveCustomer(CustomerTO customer) {
		CustomerEntity customerEntity = customerRepository.save(CustomerMapper.toCustomerEntity(customer));
		return CustomerMapper.toCustomerTO(customerEntity);
	}
	
	@Override
	public CustomerTO findCustomerById(Long id) {
		if(customerRepository.exists(id)){
			return CustomerMapper.toCustomerTO(customerRepository.getOne(id));
		}
		return null;
	}
}
