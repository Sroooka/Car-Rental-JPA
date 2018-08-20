package com.capgemini.jstk.car_rental_jpa.service;

import com.capgemini.jstk.car_rental_jpa.types.CustomerTO;

public interface CustomerService {
	public CustomerTO saveCustomer(CustomerTO customer);
}
