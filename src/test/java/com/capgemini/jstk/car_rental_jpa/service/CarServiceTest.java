package com.capgemini.jstk.car_rental_jpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.car_rental_jpa.enums.CarType;
import com.capgemini.jstk.car_rental_jpa.enums.Position;
import com.capgemini.jstk.car_rental_jpa.types.CarTO;
import com.capgemini.jstk.car_rental_jpa.types.CarTO.CarTOBuilder;
import com.capgemini.jstk.car_rental_jpa.types.EmployeeTO;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest (properties = "spring.profiles.active=mysql-test")
//@SpringBootTest (properties = "spring.profiles.active=hsql-test")
public class CarServiceTest {
	
	@Autowired
	CarService carService;
	
	@Autowired
	EmployeeService employeeService;
	
	
	@Test
	public void shouldFindCorrectAmountWhenFindAllCars(){
		//given
		int sizeBeforeDelete = carService.length();
		for(int i = 0; i < 500; i++){
			carService.saveCar(getMercedesCar());
			carService.saveCar(getPorscheCar());
		}
		
		//when
		List<CarTO> selectedCars = carService.findAllCars();
		
		// then
		assertNotNull(selectedCars.get(0));
		assertEquals(selectedCars.size(), 1000 + sizeBeforeDelete);
	}
	
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
	
	@Test
	public void shouldReturnTrueIfContainsElement() {
		// given when
		CarTO addedCar = carService.saveCar(getPorscheCar());

		// then
		assertEquals(carService.contains(addedCar.getId()), true);
		assertEquals(carService.contains(addedCar.getId() + 1), false);
	}
	
	@Test
	public void shouldAddCarer(){
		//given
		CarTO car = carService.saveCar(getBrabusCar());
		EmployeeTO employee = employeeService.saveEmployee(getEmployee());
		
		// when
		carService.addCarer(car.getId(), employee.getId());
		List<CarTO> listOfCarsFromEmployee = carService.findCarsByCarerID(employee.getId());
		List<CarTO> carsOwnedByEmployee = employeeService.getCaredCarsByEmployeeId(employee.getId());
		// then
		assertNotNull(listOfCarsFromEmployee);
		assertEquals(listOfCarsFromEmployee.get(0).getManufacturer(), "Brabus");
		assertEquals(listOfCarsFromEmployee.get(0).getModel(), "E63");
		assertEquals(carsOwnedByEmployee.get(0).getManufacturer(), "Brabus");
		assertEquals(carsOwnedByEmployee.get(0).getModel(), "E63");
	}
	
	@Test
	public void shouldFindCarsByCarerId(){
		//given
		EmployeeTO employee = employeeService.saveEmployee(getEmployee());
		for(int i=0; i<100;i++){
			CarTO car = carService.saveCar(getBrabusCar());
			carService.addCarer(car.getId(), employee.getId());
		}
		
		// when
		List<CarTO> listOfCarsFromEmployee = carService.findCarsByCarerID(employee.getId());
		// then
		assertNotNull(listOfCarsFromEmployee);
		assertEquals(listOfCarsFromEmployee.get(0).getManufacturer(), "Brabus");
		assertEquals(listOfCarsFromEmployee.get(0).getModel(), "E63");
		assertEquals(listOfCarsFromEmployee.size(), 100);
	}
	
	@Test
	public void shouldFindByCarTypeAndManufacturer(){
		// given
		carService.saveCar(getCabrioletCar());
		carService.saveCar(getMercedesCar());
		
		// when
		List<CarTO> selectedCars = carService.findCarByCarTypeAndManufacturer(CarType.CABRIOLET, "mercedes");
		// then
		assertNotNull(selectedCars);
		assertEquals(selectedCars.size(), 1);
		assertEquals(selectedCars.get(0).getManufacturer(), "Mercedes");
		assertEquals(selectedCars.get(0).getModel(), "AMG GT");
		assertEquals(selectedCars.get(0).getProductionYear(), 2018);
		assertEquals(selectedCars.get(0).getCarType(), CarType.CABRIOLET);
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
	
	private CarTO getBrabusCar(){
		CarTO car = new CarTO();
		car.setManufacturer("Brabus");
		car.setModel("E63");
		car.setProductionYear(2009);
		car.setCarType(CarType.WAGON);
		car.setColor("Black");
		car.setEngineSize(6296);
		car.setPower(807);
		return car;
	}
	
	private CarTO getCabrioletCar(){
		CarTO car = new CarTO();
		car.setManufacturer("Mercedes");
		car.setModel("AMG GT");
		car.setProductionYear(2018);
		car.setCarType(CarType.CABRIOLET);
		car.setColor("White pearl");
		car.setEngineSize(6296);
		car.setPower(972);
		return car;
	}
	
	private EmployeeTO getEmployee(){
		EmployeeTO employee = new EmployeeTO();
		employee.setName("Jan");
		employee.setSurname("Kowalski");
		employee.setPosition(Position.MANAGER);
		return employee;
	}
}
