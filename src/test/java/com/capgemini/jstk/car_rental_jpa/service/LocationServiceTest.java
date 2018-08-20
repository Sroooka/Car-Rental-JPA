package com.capgemini.jstk.car_rental_jpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.car_rental_jpa.domain.EmployeeEntity;
import com.capgemini.jstk.car_rental_jpa.enums.CarType;
import com.capgemini.jstk.car_rental_jpa.enums.Position;
import com.capgemini.jstk.car_rental_jpa.types.CarTO;
import com.capgemini.jstk.car_rental_jpa.types.EmployeeTO;
import com.capgemini.jstk.car_rental_jpa.types.LocationTO;
import com.capgemini.jstk.car_rental_jpa.types.CarTO.CarTOBuilder;
import com.capgemini.jstk.car_rental_jpa.types.LocationTO.LocationTOBuilder;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql-test")
// @SpringBootTest (properties = "spring.profiles.active=hsql-test")
public class LocationServiceTest {

	@Autowired
	LocationService locationService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	CarService carService;

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
	
	@Test
	public void shouldAddEmployeeToLocation() {
		// given
		LocationTO addedLocation = locationService.saveLocation(getLocationPoznan());
		EmployeeTO addedEmployee = employeeService.saveEmployee(getEmployeeKowalski());
		
		//when
		boolean isEmployeeAdded = locationService.addEmployeeToLocation(addedLocation.getId(), addedEmployee.getId());
		EmployeeEntity employeeEntityFromRepository = employeeService.findEmployeeEntityById(addedEmployee.getId());
		Set<EmployeeEntity> employeeSetFromLocation = locationService.findLocationEntityById(addedLocation.getId()).getEmployee();
		
		// then
		assertTrue(isEmployeeAdded);
		assertNotNull(employeeEntityFromRepository);
		assertNotNull(employeeSetFromLocation);
		assertEquals(employeeEntityFromRepository.getLocation().getAddress(), "Dabrowskiego 50");
		assertEquals(employeeEntityFromRepository.getLocation().getCity(), "Poznan");
		assertEquals(employeeEntityFromRepository.getLocation().getEmail(), "office.poznan@domain.com");
		assertEquals(employeeEntityFromRepository.getLocation().getPhone(), "880-088-808");
		assertEquals(employeeEntityFromRepository.getLocation().getPostalCode(), "60123");
		assertEquals(employeeSetFromLocation.iterator().next().getLocation().getAddress(), "Dabrowskiego 50");
	}
	
	@Test
	public void shouldDeleteEmployeeFromLocation() {
		// given
		LocationTO addedLocation = locationService.saveLocation(getLocationPoznan());
		EmployeeTO addedEmployee = employeeService.saveEmployee(getEmployeeKowalski());
		boolean isEmployeeAdded = locationService.addEmployeeToLocation(addedLocation.getId(), addedEmployee.getId());
		int employeeListLengthBeforeDelete = locationService.findLocationEntityById(addedLocation.getId()).getEmployee().size();
		//when
		boolean isEmployeeDeleted = locationService.deleteEmployeeFromLocation(addedLocation.getId(), addedEmployee.getId());
		EmployeeEntity employeeEntityFromRepository = employeeService.findEmployeeEntityById(addedEmployee.getId());
		int employeeListLengthAfterDelete = locationService.findLocationEntityById(addedLocation.getId()).getEmployee().size();

		// then
		assertTrue(isEmployeeAdded);
		assertTrue(isEmployeeDeleted);
		assertNotNull(employeeEntityFromRepository);
		assertEquals(employeeListLengthBeforeDelete, 1);
		assertEquals(employeeListLengthAfterDelete, 0);
		assertEquals(employeeEntityFromRepository.getLocation(), null);
	}
	
	@Test
	public void shouldFindEmployeesByLocation() {
		// given
		LocationTO addedLocation = locationService.saveLocation(getLocationPoznan());
		EmployeeTO addedEmployeeKowalski = employeeService.saveEmployee(getEmployeeKowalski());
		EmployeeTO addedEmployeeNowak = employeeService.saveEmployee(getEmployeeNowak());
		int employeeListLengthBeforeAdding = locationService.findLocationEntityById(addedLocation.getId()).getEmployee().size();
		locationService.addEmployeeToLocation(addedLocation.getId(), addedEmployeeKowalski.getId());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedEmployeeNowak.getId());
		//when
		int foundEmployeesAmount = locationService.findLocationEntityById(addedLocation.getId()).getEmployee().size();

		// then
		assertEquals(employeeListLengthBeforeAdding, 0);
		assertEquals(foundEmployeesAmount, 2);
	}
	
	@Test
	public void shouldFindEmployeesByLocationWhoCaresSpecifiedCar() {
		// given
		LocationTO addedLocation = locationService.saveLocation(getLocationPoznan());
		EmployeeTO addedEmployeeKowalski = employeeService.saveEmployee(getEmployeeKowalski());
		EmployeeTO addedEmployeeNowak = employeeService.saveEmployee(getEmployeeNowak());
		CarTO addedCar = carService.saveCar(getMercedesCar());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedEmployeeKowalski.getId());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedEmployeeNowak.getId());
		carService.addCarer(addedCar.getId(), addedEmployeeNowak.getId());
		//when
		List<EmployeeTO> list = locationService.findEmployeesByLocationWhoCaresCar(addedLocation.getId(), addedCar.getId());

		// then
		assertEquals(list.size(), 1);
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldReturnErrorWhenSaveLocationWithoutAddress() {
		// given
		LocationTO addedLocation = getLocationPoznan();
		addedLocation.setAddress("");
		// when then
		locationService.saveLocation(addedLocation);
	}
	
	@Test 
	public void shouldReturnNullWhenDeleteNonExistingLocation() {
		// given
		Long index=1L;
		while(locationService.contains(index)){
			index++;
		}
		// when
		LocationTO deletedLocation = locationService.deleteLocation(index);
		
		//then
		assertEquals(deletedLocation, null);
	}
	
	@Test
	public void shouldReturnNullWhenUpdateNonExistingLocation() {
		// given
		Long index=1L;
		while(locationService.contains(index)){
			index++;
		}
		// when
		LocationTO newLocation = getLocationWroclaw();
		newLocation.setId(index);
		LocationTO updatedLocation = locationService.updateLocation(newLocation);
		
		// then
		assertEquals(updatedLocation, null);

	}
	
	@Test
	public void shouldReturnFalseWhenAddEmployeeToLocation() {
		// given when
		Long indexLocation=1L;
		while(locationService.contains(indexLocation)){
			indexLocation++;
		}
		//when
		boolean isEmployeeAdded = locationService.addEmployeeToLocation(indexLocation, 1L);
		
		// then
		assertFalse(isEmployeeAdded);
	}
	
	@Test
	public void shouldReturnFalseWhenDeleteNonExistingEmployeeFromLocation() {
		// given
		LocationTO addedLocation = locationService.saveLocation(getLocationPoznan());
		EmployeeTO addedEmployee = employeeService.saveEmployee(getEmployeeKowalski());
		
		//when
		boolean isEmployeeDeleted = locationService.deleteEmployeeFromLocation(addedLocation.getId(), addedEmployee.getId());

		// then
		assertFalse(isEmployeeDeleted);
	}
	
	@Test
	public void shouldReturnNullWhenFindEmployeesByNonExistingLocation() {
		// given
		Long indexLocation=1L;
		while(locationService.contains(indexLocation)){
			indexLocation++;
		}

		//when
		List<EmployeeTO> list = locationService.findEmployeesByLocationId(indexLocation);

		// then
		assertEquals(list, null);
	}
	
	@Test
	public void shouldReturnNullWhenFindEmployeesByLocationWhoCaresSpecifiedCarWithBadCarIndex() {
		// given
		LocationTO addedLocation = locationService.saveLocation(getLocationPoznan());
		EmployeeTO addedEmployeeNowak = employeeService.saveEmployee(getEmployeeNowak());
		carService.saveCar(getMercedesCar());
		locationService.addEmployeeToLocation(addedLocation.getId(), addedEmployeeNowak.getId());
		Long indexCar=1L;
		while(carService.contains(indexCar)){
			indexCar++;
		}
		//when
		List<EmployeeTO> list = locationService.findEmployeesByLocationWhoCaresCar(addedLocation.getId(), indexCar);

		// then
		assertEquals(list, null);
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
	
	private EmployeeTO getEmployeeKowalski(){
		EmployeeTO employee = new EmployeeTO();
		employee.setName("Jan");
		employee.setSurname("Kowalski");
		employee.setPosition(Position.MANAGER);
		return employee;
	}
	
	private EmployeeTO getEmployeeNowak(){
		EmployeeTO employee = new EmployeeTO();
		employee.setName("Krzysztof");
		employee.setSurname("Nowak");
		employee.setPosition(Position.ACCOUNTANT);
		return employee;
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
}