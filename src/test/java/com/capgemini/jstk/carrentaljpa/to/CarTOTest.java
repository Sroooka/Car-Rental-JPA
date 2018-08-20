package com.capgemini.jstk.carrentaljpa.to;

import static org.junit.Assert.*;

import java.time.Year;

import org.junit.Test;
import com.capgemini.jstk.carrentaljpa.types.CarTO;

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
		// given when then
		new CarTO.CarTOBuilder()
			.withModel(model)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenNoModel() {
		// given when then
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenNoColor() {
		// given when then
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withModel(model)
			.withProductionYear(productionYear)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenProductionYearTooLow() {
		// given when
		productionYear = 1888;

		// then
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withModel(model)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenProductionYearTooHigh() {
		// given when
		productionYear = Year.now().getValue() + 2;

		// then
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withModel(model)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenEngineSizeTooLow() {
		// given when
		engineSize = 400;

		// then
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withModel(model)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenEngineSizeTooHigh() {
		// given when
		engineSize = 8000;

		// then
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withModel(model)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenPowerTooHigh() {
		// given when
		power = 1500;

		// then
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withModel(model)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenNoPower() {
		// given when
		power = 0;

		// then
		new CarTO.CarTOBuilder()
			.withManufacturer(manufacturer)
			.withModel(model)
			.withProductionYear(productionYear)
			.withColor(color)
			.withEngineSize(engineSize)
			.withPower(power)
			.build();
	}
}
