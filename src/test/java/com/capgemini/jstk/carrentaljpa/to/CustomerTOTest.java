package com.capgemini.jstk.carrentaljpa.to;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.capgemini.jstk.carrentaljpa.types.CustomerTO;

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
		// given when then
		new CustomerTO.CustomerTOBuilder()
				.withSurname(surname)
				.withAddress(address)
				.withCity(city)
				.withPostalCode(postalCode)
				.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenCreateCustomerWithoutSurame() {
		// given when
		surname = "";
		
		// then
		new CustomerTO.CustomerTOBuilder()
				.withName(name)
				.withSurname(surname)
				.withAddress(address)
				.withCity(city)
				.withPostalCode(postalCode)
				.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenCreateCustomerWithoutAddress() {
		// given when then
		new CustomerTO.CustomerTOBuilder()
				.withName(name)
				.withSurname(surname)
				.withCity(city)
				.withPostalCode(postalCode)
				.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenCreateCustomerWithoutCity() {
		// given when
		city = "";
		
		// then
		new CustomerTO.CustomerTOBuilder()
				.withName(name)
				.withSurname(surname)
				.withAddress(address)
				.withCity(city)
				.withPostalCode(postalCode)
				.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenCreateCustomerWithoutPostalCode() {
		// given when then
		new CustomerTO.CustomerTOBuilder()
				.withName(name)
				.withSurname(surname)
				.withAddress(address)
				.withCity(city)
				.build();
	}
}
