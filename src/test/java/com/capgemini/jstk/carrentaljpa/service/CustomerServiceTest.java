package com.capgemini.jstk.carrentaljpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.carrentaljpa.types.CustomerTO;
import com.capgemini.jstk.carrentaljpa.types.CustomerTO.CustomerTOBuilder;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest (properties = "spring.profiles.active=mysql-test")
//@SpringBootTest (properties = "spring.profiles.active=hsql-test")
public class CustomerServiceTest {

	@Autowired
	CustomerService customerService;
	
	@Test
	public void shouldSaveCustomer() {
		// given
		CustomerTO customer = customerService.saveCustomer(getCustomerKowalski());
		
		// when
		CustomerTO foundCustomer = customerService.findCustomerById(customer.getId());
		
		// then
		assertNotNull(foundCustomer);
		assertEquals(foundCustomer.getName(), "Jan");
		assertEquals(foundCustomer.getSurname(), "Kowalski");
		assertEquals(foundCustomer.getAddress(), "Poznanska 110");
		assertEquals(foundCustomer.getCity(), "Poznan");
		assertEquals(foundCustomer.getPostalCode(), "60123");
	}
	
	private CustomerTO getCustomerKowalski(){
		return new CustomerTOBuilder()
			.withName("Jan")
			.withSurname("Kowalski")
			.withAddress("Poznanska 110")
			.withCity("Poznan")
			.withPostalCode("60123")
			.build();
	}
}
