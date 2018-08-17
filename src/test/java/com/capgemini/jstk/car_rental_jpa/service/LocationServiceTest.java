package com.capgemini.jstk.car_rental_jpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.jstk.car_rental_jpa.types.LocationTO;
import com.capgemini.jstk.car_rental_jpa.types.LocationTO.LocationTOBuilder;

//@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql-test")
// @SpringBootTest (properties = "spring.profiles.active=hsql-test")
public class LocationServiceTest {

	@Autowired
	LocationService locationService;

	@Test
	public void shouldSaveLocation() {
		// given
		// when
		LocationTO location = locationService.saveLocation(getLocationPoznan());
		LocationTO foundLocation = locationService.findLocationById(location.getId());
		// then
		assertNotNull(foundLocation);
		assertEquals(foundLocation.getCity(), "Poznan");
		assertEquals(foundLocation.getEmail(), "office.poznan@domain.com");
		assertEquals(foundLocation.getPhone(), "880-088-808");
	}
	
	@Test
	public void shouldDeleteLocation() {
		// given
		LocationTO addedLocation = locationService.saveLocation(getLocationPoznan());
		// when
		LocationTO foundLocation = locationService.findLocationById(addedLocation.getId());
		LocationTO deletedLocation = locationService.deleteLocation(addedLocation.getId());
		boolean isDeletedLocationIsDatabase = locationService.contains(addedLocation.getId());
		
		// then
		assertNotNull(foundLocation);
		assertNotNull(deletedLocation);
		assertEquals(foundLocation.getCity(), "Poznan");
		assertEquals(foundLocation.getEmail(), "office.poznan@domain.com");
		assertEquals(foundLocation.getPhone(), "880-088-808");
		assertFalse(isDeletedLocationIsDatabase);
	}
	
	@Test
	public void shouldUpdateLocation() {
		// given
		LocationTO addedLocation = locationService.saveLocation(getLocationPoznan());
		Long idAddedLocation = addedLocation.getId();
		// when
		LocationTO newLocation = getLocationWroclaw();
		newLocation.setId(idAddedLocation);
		locationService.updateLocation(newLocation);
		LocationTO updatedLocation = locationService.findLocationById(idAddedLocation);
		
		// then
		assertNotNull(addedLocation);
		assertNotNull(updatedLocation);
		assertEquals(addedLocation.getAddress(), "Dabrowskiego 50");
		assertEquals(addedLocation.getCity(), "Poznan");
		assertEquals(addedLocation.getEmail(), "office.poznan@domain.com");
		assertEquals(addedLocation.getPhone(), "880-088-808");
		assertEquals(addedLocation.getPostalCode(), "60123");
		assertEquals(updatedLocation.getAddress(), "Piotrkowska 12");
		assertEquals(updatedLocation.getCity(), "Wroclaw");
		assertEquals(updatedLocation.getEmail(), "office.wroclaw@domain.com");
		assertEquals(updatedLocation.getPhone(), "770-077-707");
		assertEquals(updatedLocation.getPostalCode(), "50234");
	}
	
	private LocationTO getLocationPoznan() {
		return new LocationTOBuilder()
				.withAddress("Dabrowskiego 50")
				.withCity("Poznan")
				.withEmail("office.poznan@domain.com")
				.withPhone("880-088-808")
				.withPostalCode("60123")
				.build();
	}
	
	private LocationTO getLocationWroclaw() {
		return new LocationTOBuilder()
				.withAddress("Piotrkowska 12")
				.withCity("Wroclaw")
				.withEmail("office.wroclaw@domain.com")
				.withPhone("770-077-707")
				.withPostalCode("50234")
				.build();
	}
}