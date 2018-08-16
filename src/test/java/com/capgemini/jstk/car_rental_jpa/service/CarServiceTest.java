package com.capgemini.jstk.car_rental_jpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.car_rental_jpa.enums.CarType;
import com.capgemini.jstk.car_rental_jpa.types.CarTO;
import com.capgemini.jstk.car_rental_jpa.types.CarTO.CarTOBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest (properties = "spring.profiles.active=test")
public class CarServiceTest {
	
	@Autowired
	CarService carService;
	
	@Before
	public void init(){

	}
	
	@Transactional
	@Test
	public void shouldFindCorrectAmountWhenFindAllCars(){
		//given
		for(int i = 0; i < 500; i++){
			carService.saveCar(getMercedesCar());
			carService.saveCar(getPorscheCar());
		}
		//when
		List<CarTO> selectedCars = carService.findAllCars();
		
		// then
				assertNotNull(selectedCars.get(0));
				assertEquals(selectedCars.size(), 1000);
	}
	
	@Transactional
	@Test
	public void shouldFindCarsByManufacturer(){
		// given
		carService.saveCar(getPorscheCar());
		CarTO savedCar = carService.saveCar(getMercedesCar());
		
		// when
		List<CarTO> selectedCars = carService.findCarByManufacturer("mercedes");

		// then
		assertNotNull(selectedCars.get(0));
		assertEquals(selectedCars.get(0).getManufacturer(), savedCar.getManufacturer());
		assertEquals(selectedCars.get(0).getModel(), savedCar.getModel());
	}
	
	@Transactional
	@Test
	public void shouldFindCarsByModel(){
		// given
		carService.saveCar(getPorscheCar());
		CarTO savedCar = carService.saveCar(getMercedesCar());
		
		// when
		List<CarTO> selectedCars = carService.findCarByModel("W204");

		// then
		assertNotNull(selectedCars.get(0));
		assertEquals(selectedCars.get(0).getManufacturer(), savedCar.getManufacturer());
		assertEquals(selectedCars.get(0).getModel(), savedCar.getModel());
	}
	
	@Transactional
	@Test
	public void shouldFindCarsByProductionYear(){
		// given
		carService.saveCar(getPorscheCar());
		carService.saveCar(getMercedesCar());
		
		// when
		List<CarTO> selectedCars = carService.findCarByProductionYear(2012);

		// then
		assertNotNull(selectedCars.get(0));
		assertEquals(selectedCars.get(0).getProductionYear(), 2012);
	}
	
	@Transactional
	@Test
	public void shouldFindCarsByCarType(){
		// given
		carService.saveCar(getPorscheCar());
		carService.saveCar(getMercedesCar());
		
		// when
		List<CarTO> selectedCars = carService.findCarByCarType(CarType.COUPE);

		// then
		assertNotNull(selectedCars.get(0));
		assertEquals(selectedCars.get(0).getProductionYear(), 2012);
		assertEquals(selectedCars.get(0).getCarType(), CarType.COUPE);
	}
	
	@Transactional
	@Test
	public void shouldDeleteCar(){
		//given
		carService.saveCar(getMercedesCar());
		//when
		CarTO foundCar = carService.findCarById(1L);
		CarTO deletedCar = carService.deleteCar(1L);
		boolean containsCar = carService.contains(1L);
		
		// then
		assertNotNull(foundCar);
		assertEquals(foundCar.getManufacturer(), "Mercedes");
		assertEquals(foundCar.getModel(), "W204");
		assertEquals(foundCar, deletedCar);
		assertFalse(containsCar);
	}
	
	@Transactional
	@Test
	public void shouldUpdateCar(){
		//given
		CarTO beforeUpdateCar = carService.saveCar(getMercedesCar());
		Long idSavedCar = beforeUpdateCar.getId();
		// when
		CarTO newCar = getAudiCar();
		newCar.setId(idSavedCar);
		carService.updateCar(newCar);
		CarTO afterUpdateCar = carService.findCarById(idSavedCar);
		
		// then
		assertNotNull(afterUpdateCar);
		assertEquals(beforeUpdateCar.getManufacturer(), "Mercedes");
		assertEquals(beforeUpdateCar.getModel(), "W204");
		assertEquals(afterUpdateCar.getManufacturer(), "Audi");
		assertEquals(afterUpdateCar.getModel(), "A8");
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
	
	private CarTO getPorscheCar(){
		return new CarTOBuilder()
				.withManufacturer("Porsche")
				.withModel("Cayenne")
				.withColor("black")
				.withProductionYear(2009)
				.withEngineSize(4998)
				.withPower(354)
				.withCarType(CarType.SUV)
				.build();
	}
	
	private CarTO getAudiCar(){
		return new CarTOBuilder()
				.withManufacturer("Audi")
				.withModel("A8")
				.withColor("silver")
				.withProductionYear(2017)
				.withEngineSize(3000)
				.withPower(310)
				.withCarType(CarType.SEDAN)
				.build();
	}
}
