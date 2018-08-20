package com.capgemini.jstk.car_rental_jpa.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.car_rental_jpa.enums.CarType;
import com.capgemini.jstk.car_rental_jpa.types.CarTO;
import com.capgemini.jstk.car_rental_jpa.types.CustomerTO;
import com.capgemini.jstk.car_rental_jpa.types.LocationTO;
import com.capgemini.jstk.car_rental_jpa.types.CustomerTO.CustomerTOBuilder;
import com.capgemini.jstk.car_rental_jpa.types.LocationTO.LocationTOBuilder;
import com.capgemini.jstk.car_rental_jpa.types.RentalTO;
import com.capgemini.jstk.car_rental_jpa.types.CarTO.CarTOBuilder;
import com.capgemini.jstk.car_rental_jpa.types.RentalTO.RentalTOBuilder;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest (properties = "spring.profiles.active=mysql-test")
//@SpringBootTest (properties = "spring.profiles.active=hsql-test")
public class RentalServiceTest {
	@Autowired
	RentalService rentalService;
	
	@Autowired
	CarService carService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	LocationService locationService;

	@Autowired 
	CustomerService customerService;
	
	@Test
	public void shouldAddRental() {
		// given
		CarTO addedCar = carService.saveCar(getMercedesCar());
		CustomerTO addedCustomer = customerService.saveCustomer(getCustomerKowalski());
		LocationTO startLocation = locationService.saveLocation(getLocationWroclaw());
		LocationTO endLocation = locationService.saveLocation(getLocationWroclaw());
		RentalTO savedRental = rentalService.saveRental(getRental(addedCar, addedCustomer, startLocation, endLocation));
		// when
		RentalTO foundRental = rentalService.findRentalById(savedRental.getId());
		// then
		assertEquals(savedRental.getCustomer(), foundRental.getCustomer());
		assertEquals(savedRental.getCar(), foundRental.getCar());
		assertEquals(savedRental.getStartLocation(), foundRental.getStartLocation());
		assertEquals(savedRental.getEndLocation(), foundRental.getEndLocation());
		assertEquals(savedRental.getCost(), foundRental.getCost());
	}
	
	private RentalTO getRental(CarTO car, CustomerTO customer, LocationTO startLocation, LocationTO endLocation){
		return new RentalTOBuilder()
			.withCustomer(customer)	
			.withCar(car)
			.withRentBegin(new Date())
			.withRentEnd(new Date())
			.withStartLocation(startLocation)
			.withEndLocation(endLocation)
			.withCost(1500)
			.build();
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
	
	private CarTO getMercedesCar(){
		return new CarTOBuilder()
				.withManufacturer("Mercedes")
				.withModel("W204")
				.withColor("white")
				.withProductionYear(2012)
				.withEngineSize(1796)
				.withPower(170)
				.withCarType(CarType.COUPE)
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
