package com.capgemini.jstk.car_rental_jpa.to;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.capgemini.jstk.car_rental_jpa.types.CustomerTO;

public class CustomerTOTest {
	String name = "Jan";
	String surname = "Kowalski";
	String address = "Przemyslowa 5";
	String city = "Poznan";
	String postalCode = "61-901";
	
	@Test
	public void shouldCreateCustomer() {

		// given when
		CustomerTO customer = new CustomerTO.CustomerTOBuilder()
				.withId(12345678L)
				.withName(name)
				.withSurname(surname)
				.withAddress(address)
				.withCity(city)
				.withPostalCode(postalCode)
				.build();

		// then
		assertNotNull(customer);
		assertTrue(customer.getId() == 12345678L);
		assertEquals(customer.getName(), name);
		assertEquals(customer.getSurname(), surname);
		assertEquals(customer.getAddress(), address);
		assertEquals(customer.getCity(), city);
		assertEquals(customer.getPostalCode(), postalCode);
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenCreateCustomerWithoutName() {

		// given when
		new CustomerTO.CustomerTOBuilder()
				.withSurname(surname)
				.withAddress(address)
				.withCity(city)
				.withPostalCode(postalCode)
				.build();

		// then
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenCreateCustomerWithoutSurame() {

		// given 
		surname = "";
		
		//when
		new CustomerTO.CustomerTOBuilder()
				.withName(name)
				.withSurname(surname)
				.withAddress(address)
				.withCity(city)
				.withPostalCode(postalCode)
				.build();

		// then
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenCreateCustomerWithoutAddress() {

		// given when
		new CustomerTO.CustomerTOBuilder()
				.withName(name)
				.withSurname(surname)
				.withCity(city)
				.withPostalCode(postalCode)
				.build();

		// then
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenCreateCustomerWithoutCity() {

		// given 
		city = "";
		
		//when
		new CustomerTO.CustomerTOBuilder()
				.withName(name)
				.withSurname(surname)
				.withAddress(address)
				.withCity(city)
				.withPostalCode(postalCode)
				.build();

		// then
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenCreateCustomerWithoutPostalCode() {

		// given when
		new CustomerTO.CustomerTOBuilder()
				.withName(name)
				.withSurname(surname)
				.withAddress(address)
				.withCity(city)
				.build();

		// then
	}
}
