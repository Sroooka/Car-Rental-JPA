package com.capgemini.jstk.car_rental_jpa.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.car_rental_jpa.dao.CarDao;
import com.capgemini.jstk.car_rental_jpa.dao.EmployeeDao;
import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.domain.EmployeeEntity;
import com.capgemini.jstk.car_rental_jpa.mappers.CarMapper;
import com.capgemini.jstk.car_rental_jpa.service.CarService;
import com.capgemini.jstk.car_rental_jpa.enums.CarType;
import com.capgemini.jstk.car_rental_jpa.types.CarTO;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService{
	@Autowired
	private CarDao carRepository;
	
	@Autowired
	private EmployeeDao employeeRepository;

	@Override
	public List<CarTO> findAllCars() {
		List<CarEntity> allCars = carRepository.findAll();
		return CarMapper.map2TOs(allCars);
	}
	
	@Override
	public CarTO findCarById(Long id) {
		if(carRepository.exists(id)){
			return CarMapper.toCarTO(carRepository.getOne(id));
		}
		return null;
	}
	
	@Override
	public boolean contains(Long id){
		return carRepository.exists(id);
	}
	
	@Override
	public CarEntity findCarEntityById(Long id) {
		if(carRepository.exists(id)){
			return carRepository.getOne(id);
		}
		return null;
	}
	
	@Override
	public List<CarTO> findCarByManufacturer(String manufacturer) {
		List<CarEntity> allCars = carRepository.findCarsByManufacturer(manufacturer);
		return CarMapper.map2TOs(allCars);
	}
	
	@Override
	public List<CarTO> findCarByModel(String model) {
		List<CarEntity> allCars = carRepository.findCarsByModel(model);
		return CarMapper.map2TOs(allCars);
	}
	
	@Override
	public List<CarTO> findCarByProductionYear(int productionYear) {
		List<CarEntity> allCars = carRepository.findCarsByProductionYear(productionYear);
		return CarMapper.map2TOs(allCars);
	}
	
	@Transactional(readOnly = false)
	@Override
	public CarTO saveCar(CarTO car) {
		CarEntity carEntity = carRepository.save(CarMapper.toCarEntity(car));
		return CarMapper.toCarTO(carEntity);
	}
	
	@Override
	//@Transactional(readOnly = false)
	public CarEntity saveEntityCar(CarEntity car) {
		carRepository.save(car);
		return car;
	}

	@Transactional(readOnly = false)
	@Override
	public void clear() {
		carRepository.deleteAll();
	}

	@Override
	public List<CarTO> findCarByCarType(CarType carType) {
		List<CarEntity> allCars = carRepository.findCarsByCarType(carType);
		return CarMapper.map2TOs(allCars);
	}
	
	@Override
	public List<CarTO> findCarsByCarerID(Long carerId) {
		List<CarEntity> carsWithSpecifiedCarer = carRepository.findCarsByCarer(carerId);
		return CarMapper.map2TOs(carsWithSpecifiedCarer);
	}

	@Transactional(readOnly = false)
	@Override
	public CarTO deleteCar(Long id) {
		if(!carRepository.exists(id)){
			return null;
		}
		CarTO car = CarMapper.toCarTO(carRepository.getOne(id));
		carRepository.delete(id);
		return car;
	}

	@Transactional(readOnly = false)
	@Override
	public CarTO updateCar(CarTO newCar) {
		if(!carRepository.exists(newCar.getId())){
			return null;
		}
		CarEntity updatedCar = findCarEntityById(newCar.getId());
		updatedCar.setManufacturer(newCar.getManufacturer());
		updatedCar.setModel(newCar.getModel());
		updatedCar.setProductionYear(newCar.getProductionYear());
		updatedCar.setColor(newCar.getColor());
		updatedCar.setEngineSize(newCar.getEngineSize());
		updatedCar.setPower(newCar.getPower());
		updatedCar.setCarType(newCar.getCarType());
		return CarMapper.toCarTO(carRepository.update(updatedCar));
	}

	@Transactional(readOnly = false)
	@Override
	public boolean addCarer(Long carId, Long employeeId) {
		if(!(employeeRepository.exists(employeeId) && carRepository.exists(carId))){
			return false;
		}	
		//carRepository.addCarer(carId, employeeRepository.getOne(employeeId));
		//employeeRepository.addCarer(employeeId, carRepository.findOne(carId));
		CarEntity car = carRepository.findOne(carId);
		EmployeeEntity employee = employeeRepository.findOne(employeeId);
		car.getCarers().add(employee);
		employee.getCars().add(car);
		carRepository.update(car);
		return true;
	}

	@Override
	public int length() {
		return carRepository.findAll().size();
	}

	@Override
	public List<CarTO> findCarByCarTypeAndManufacturer(CarType carType, String manufacturer) {
		List<CarEntity> cars = carRepository.findCarByCarTypeAndManufacturer(carType, manufacturer);
		return CarMapper.map2TOs(cars);
	}
}
