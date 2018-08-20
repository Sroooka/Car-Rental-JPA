package com.capgemini.jstk.carrentaljpa.service;

import com.capgemini.jstk.carrentaljpa.types.CustomerTO;

public interface CustomerService {
	public CustomerTO saveCustomer(CustomerTO customer);
	
	public CustomerTO findCustomerById(Long id);
}
