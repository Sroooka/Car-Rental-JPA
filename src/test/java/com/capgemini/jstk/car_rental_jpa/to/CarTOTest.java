package com.capgemini.jstk.car_rental_jpa.to;

import static org.junit.Assert.*;

import java.time.Year;

import org.junit.Test;
import com.capgemini.jstk.car_rental_jpa.types.CarTO;

public class CarTOTest {
	
	String manufacturer = "Mercedes";
	String model = "W204";
	int productionYear = 2012;
	String color = "white";
	int engineSize = 1796;
	int power = 170;
	
	@Test
	public void shouldCreateCar() {

		// given when
		CarTO car = new CarTO.CarTOBuilder()
				.withManufacturer(manufacturer)
				.withModel(model)
				.withProductionYear(productionYear)
				.withColor(color)
				.withEngineSize(engineSize)
				.withPower(power)
				.build();

		// then
		assertNotNull(car);
		assertTrue(car.getId() == 0L);
		assertEquals(car.getManufacturer(), manufacturer);
		assertEquals(car.getModel(), model);
		assertEquals(car.getProductionYear(), productionYear);
		assertEquals(car.getColor(), color);
		assertEquals(car.getEngineSize(), engineSize);
		assertEquals(car.getPower(), power);
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenNoManufacturer() {

		// given when
		new CarTO.CarTOBuilder()
			.withModel(model)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();

		// then
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenNoModel() {

		// given when
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();

		// then
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenNoColor() {

		// given when
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withModel(model)
			.withProductionYear(productionYear)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();

		// then
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenProductionYearTooLow() {

		// given
		productionYear = 1888;

		// when
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withModel(model)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();

		// then
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenProductionYearTooHigh() {

		// given
		productionYear = Year.now().getValue() + 2;

		// when
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withModel(model)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();

		// then
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenEngineSizeTooLow() {

		// given
		engineSize = 400;

		// when
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withModel(model)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();

		// then
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenEngineSizeTooHigh() {

		// given
		engineSize = 8000;

		// when
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withModel(model)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();

		// then
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenPowerTooHigh() {

		// given
		power = 1500;

		// when
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withModel(model)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();

		// then
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenNoPower() {

		// given
		power = 0;

		// when
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withModel(model)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();

		// then
	}
}
