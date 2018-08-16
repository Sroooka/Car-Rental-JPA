package com.capgemini.jstk.car_rental_jpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.jstk.car_rental_jpa.types.CarTO;
import com.capgemini.jstk.car_rental_jpa.types.CarTO.CarTOBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {
	
	@Autowired
	CarService carService;
	
	@Test
	public void shouldFindAllCarsByManufacturer(){
		// given
		CarTO car = new CarTOBuilder()
				.withId(66L)
				.withManufacturer("Mercedes")
				.withModel("W204")
				.withColor("white")
				.withProductionYear(2012)
				.withEngineSize(1796)
				.withPower(170)
				.build();
		carService.findAllCars();
		CarTO savedCar = carService.saveCar(car);
				
		// when
		//List<CarTO> selectedCars = carService.findCarByManufacturer("mercedes");

		// then
		//assertNotNull(selectedCars.get(0));
		//assertEquals(selectedCars.get(0).getManufacturer(), savedCar.getManufacturer());
		//assertEquals(selectedCars.get(0).getModel(), savedCar.getModel());
	}
}
