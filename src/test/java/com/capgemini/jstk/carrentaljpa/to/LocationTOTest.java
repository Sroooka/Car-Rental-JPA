package com.capgemini.jstk.carrentaljpa.to;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.capgemini.jstk.carrentaljpa.types.LocationTO;

public class LocationTOTest {
	String address = "Dabrowskiego 50";
	String city = "Poznan";
	String postalCode = "60-111";
	String phone = "808-880-088";
	String email = "biuro@domain.com";
	
	@Test
	public void shouldCreateLocation() {
		// given when
		LocationTO location = new LocationTO.LocationTOBuilder()
				.withId(12345678L)
				.withAddress(address)
				.withCity(city)
				.withPostalCode(postalCode)
				.withPhone(phone)
				.withEmail(email)
				.build();

		// then
		assertNotNull(location);
		assertTrue(location.getId() == 12345678L);
		assertEquals(location.getAddress(), address);
		assertEquals(location.getCity(), city);
		assertEquals(location.getPostalCode(), postalCode);
		assertEquals(location.getPhone(), phone);
		assertEquals(location.getEmail(), email);
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenCreateLocationWithoutAddress() {
		// given when then
		new LocationTO.LocationTOBuilder()
				.withId(12345678L)
				.withCity(city)
				.withPostalCode(postalCode)
				.withPhone(phone)
				.withEmail(email)
				.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenCreateLocationWithoutCity() {
		// given when then
		new LocationTO.LocationTOBuilder()
				.withId(12345678L)
				.withAddress(address)
				.withPostalCode(postalCode)
				.withPhone(phone)
				.withEmail(email)
				.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenCreateLocationWithoutPostalCode() {
		// given when then
		new LocationTO.LocationTOBuilder()
				.withId(12345678L)
				.withAddress(address)
				.withCity(city)
				.withPhone(phone)
				.withEmail(email)
				.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenCreateLocationWithoutPhone() {
		// given when then
		new LocationTO.LocationTOBuilder()
				.withId(12345678L)
				.withAddress(address)
				.withCity(city)
				.withPostalCode(postalCode)
				.withEmail(email)
				.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenCreateLocationWithoutEmail() {
		// given when then
		new LocationTO.LocationTOBuilder()
				.withId(12345678L)
				.withAddress(address)
				.withCity(city)
				.withPostalCode(postalCode)
				.withPhone(phone)
				.build();
	}
}
