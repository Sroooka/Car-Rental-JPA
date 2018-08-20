package com.capgemini.jstk.carrentaljpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.carrentaljpa.criterias.EmployeeSearchCriteria;
import com.capgemini.jstk.carrentaljpa.criterias.EmployeeSearchCriteria.EmployeeSearchCriteriaBuilder;
import com.capgemini.jstk.carrentaljpa.enums.CarType;
import com.capgemini.jstk.carrentaljpa.enums.Position;
import com.capgemini.jstk.carrentaljpa.types.CarTO;
import com.capgemini.jstk.carrentaljpa.types.EmployeeTO;
import com.capgemini.jstk.carrentaljpa.types.LocationTO;
import com.capgemini.jstk.carrentaljpa.types.LocationTO.LocationTOBuilder;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest (properties = "spring.profiles.active=mysql-test")
//@SpringBootTest (properties = "spring.profiles.active=hsql-test")
public class EmployeeServiceTest {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired 
	LocationService locationService;
	
	@Autowired
	CarService carService;
	
	@Test
	public void shouldSaveEmployee() {
		// given
		EmployeeTO employee = employeeService.saveEmployee(getEmployeeKowalski());
		
		// when
		EmployeeTO foundEmployee = employeeService.findEmployeeById(employee.getId());
		
		// then
		assertNotNull(foundEmployee);
		assertEquals(foundEmployee.getName(), "Jan");
		assertEquals(foundEmployee.getSurname(), "Kowalski");
		assertEquals(foundEmployee.getPosition(), Position.MANAGER);
	}
	
	@Test
	public void shouldFindEmployeeByAllCriteria(){
		// given
		EmployeeTO addedKowalskiEmployee = employeeService.saveEmployee(getEmployeeKowalski());
		EmployeeTO addedNowakEmployee = employeeService.saveEmployee(getEmployeeNowak());
		LocationTO addedLocation = locationService.saveLocation(getLocationWroclaw());
		CarTO addedCabrioCar = carService.saveCar(getCabrioletCar());
		CarTO addedBrabusCar = carService.saveCar(getBrabusCar());
		carService.addCarer(addedCabrioCar.getId(), addedKowalskiEmployee.getId());
		carService.addCarer(addedBrabusCar.getId(), addedKowalskiEmployee.getId());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedKowalskiEmployee.getId());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedNowakEmployee.getId());
		EmployeeSearchCriteria criteria = new EmployeeSearchCriteriaBuilder()
				.withCaredCar(addedCabrioCar)
				.withLocation(addedLocation)
				.withPosition(addedKowalskiEmployee.getPosition())
				.build();
		
		// when
		List<EmployeeTO> list = employeeService.searchByCriteria(criteria);		
		
		// then
		assertEquals(list.size(), 1);
	}
	
	@Test
	public void shouldFindEmployeeByCaredCarAndLocation(){
		// given
		EmployeeTO addedKowalskiEmployee = employeeService.saveEmployee(getEmployeeKowalski());
		EmployeeTO addedNowakEmployee = employeeService.saveEmployee(getEmployeeNowak());
		LocationTO addedLocation = locationService.saveLocation(getLocationWroclaw());
		CarTO addedCabrioCar = carService.saveCar(getCabrioletCar());
		CarTO addedBrabusCar = carService.saveCar(getBrabusCar());
		carService.addCarer(addedCabrioCar.getId(), addedKowalskiEmployee.getId());
		carService.addCarer(addedBrabusCar.getId(), addedKowalskiEmployee.getId());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedKowalskiEmployee.getId());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedNowakEmployee.getId());
		EmployeeSearchCriteria criteria = new EmployeeSearchCriteriaBuilder()
				.withCaredCar(addedCabrioCar)
				.withLocation(addedLocation)
				.build();
		
		// when
		List<EmployeeTO> list = employeeService.searchByCriteria(criteria);		
		
		// then
		assertEquals(list.size(), 1);
	}
	
	@Test
	public void shouldFindEmployeeByCaredCarAndPosition(){
		// given
		EmployeeTO addedKowalskiEmployee = employeeService.saveEmployee(getEmployeeKowalski());
		EmployeeTO addedNowakEmployee = employeeService.saveEmployee(getEmployeeNowak());
		LocationTO addedLocation = locationService.saveLocation(getLocationWroclaw());
		CarTO addedCabrioCar = carService.saveCar(getCabrioletCar());
		CarTO addedBrabusCar = carService.saveCar(getBrabusCar());
		carService.addCarer(addedCabrioCar.getId(), addedKowalskiEmployee.getId());
		carService.addCarer(addedBrabusCar.getId(), addedKowalskiEmployee.getId());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedKowalskiEmployee.getId());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedNowakEmployee.getId());
		EmployeeSearchCriteria criteria = new EmployeeSearchCriteriaBuilder()
				.withCaredCar(addedCabrioCar)
				.withPosition(addedKowalskiEmployee.getPosition())
				.build();
		
		// when
		List<EmployeeTO> list = employeeService.searchByCriteria(criteria);		
		
		// then
		assertEquals(list.size(), 1);
	}
	
	@Test
	public void shouldFindEmployeeByLocationAndPosition(){
		// given
		EmployeeTO addedKowalskiEmployee = employeeService.saveEmployee(getEmployeeKowalski());
		EmployeeTO addedNowakEmployee = employeeService.saveEmployee(getEmployeeNowak());
		LocationTO addedLocation = locationService.saveLocation(getLocationWroclaw());
		CarTO addedCabrioCar = carService.saveCar(getCabrioletCar());
		CarTO addedBrabusCar = carService.saveCar(getBrabusCar());
		carService.addCarer(addedCabrioCar.getId(), addedKowalskiEmployee.getId());
		carService.addCarer(addedBrabusCar.getId(), addedKowalskiEmployee.getId());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedKowalskiEmployee.getId());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedNowakEmployee.getId());
		EmployeeSearchCriteria criteria = new EmployeeSearchCriteriaBuilder()
				.withLocation(addedLocation)
				.withPosition(addedKowalskiEmployee.getPosition())
				.build();
		
		// when
		List<EmployeeTO> list = employeeService.searchByCriteria(criteria);		
		
		// then
		assertEquals(list.size(), 1);
	}
	
	@Test
	public void shouldFindEmployeeByLocation(){
		// given
		EmployeeTO addedKowalskiEmployee = employeeService.saveEmployee(getEmployeeKowalski());
		EmployeeTO addedNowakEmployee = employeeService.saveEmployee(getEmployeeNowak());
		LocationTO addedLocation = locationService.saveLocation(getLocationWroclaw());
		CarTO addedCabrioCar = carService.saveCar(getCabrioletCar());
		CarTO addedBrabusCar = carService.saveCar(getBrabusCar());
		carService.addCarer(addedCabrioCar.getId(), addedKowalskiEmployee.getId());
		carService.addCarer(addedBrabusCar.getId(), addedKowalskiEmployee.getId());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedKowalskiEmployee.getId());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedNowakEmployee.getId());
		EmployeeSearchCriteria criteria = new EmployeeSearchCriteriaBuilder()
				.withLocation(addedLocation)
				.build();
		
		// when
		List<EmployeeTO> list = employeeService.searchByCriteria(criteria);		
		
		// then
		assertEquals(list.size(), 2);
	}
	
	@Test
	public void shouldFindEmployeeByCaredCar(){
		// given
		EmployeeTO addedKowalskiEmployee = employeeService.saveEmployee(getEmployeeKowalski());
		EmployeeTO addedNowakEmployee = employeeService.saveEmployee(getEmployeeNowak());
		LocationTO addedLocation = locationService.saveLocation(getLocationWroclaw());
		CarTO addedCabrioCar = carService.saveCar(getCabrioletCar());
		CarTO addedBrabusCar = carService.saveCar(getBrabusCar());
		carService.addCarer(addedCabrioCar.getId(), addedKowalskiEmployee.getId());
		carService.addCarer(addedBrabusCar.getId(), addedKowalskiEmployee.getId());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedKowalskiEmployee.getId());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedNowakEmployee.getId());
		EmployeeSearchCriteria criteria = new EmployeeSearchCriteriaBuilder()
				.withCaredCar(addedCabrioCar)
				.build();
		
		// when
		List<EmployeeTO> list = employeeService.searchByCriteria(criteria);		
		
		// then
		assertEquals(list.size(), 1);
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
	
	private EmployeeTO getEmployeeKowalski(){
		EmployeeTO employee = new EmployeeTO();
		employee.setName("Jan");
		employee.setSurname("Kowalski");
		employee.setPosition(Position.MANAGER);
		return employee;
	}
	
	private EmployeeTO getEmployeeNowak(){
		EmployeeTO employee = new EmployeeTO();
		employee.setName("Piotr");
		employee.setSurname("Nowak");
		employee.setPosition(Position.DEALER);
		return employee;
	}
	
	private LocationTO getLocationWroclaw() {
		return new LocationTOBuilder()
				.withAddress("Piotrkowska 152")
				.withCity("Wroclaw")
				.withEmail("office.wroclaw@domain.com")
				.withPhone("770-077-707")
				.withPostalCode("50234")
				.build();
	}
}
