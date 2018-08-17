package com.capgemini.jstk.car_rental_jpa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.car_rental_jpa.dao.CarDao;
import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.domain.EmployeeEntity;
import com.capgemini.jstk.car_rental_jpa.mappers.CarMapper;
import com.capgemini.jstk.car_rental_jpa.service.CarService;
import com.capgemini.jstk.car_rental_jpa.service.EmployeeService;
import com.capgemini.jstk.car_rental_jpa.enums.CarType;
import com.capgemini.jstk.car_rental_jpa.types.CarTO;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService{
	@Autowired
	private CarDao carRepository;
	
	@Autowired
	private EmployeeService employeeService;

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
	
	@Override
	@Transactional(readOnly = false)
	public CarTO saveCar(CarTO car) {
		CarEntity carEntity = carRepository.save(CarMapper.toCarEntity(car));
		return CarMapper.toCarTO(carEntity);
	}
	
	@Override
	@Transactional(readOnly = false)
	public CarEntity saveEntityCar(CarEntity car) {
		carRepository.save(car);
		return car;
	}

	@Override
	@Transactional(readOnly = false)
	public void clear() {
		carRepository.deleteAll();
	}

	@Override
	public List<CarTO> findCarByCarType(CarType carType) {
		List<CarEntity> allCars = carRepository.findCarsByCarType(carType);
		return CarMapper.map2TOs(allCars);
	}
	
	@Override
	public List<EmployeeEntity> findCarersByCarID(Long id) {
		if(!carRepository.exists(id)){
			return null;
		}
		return carRepository.findOne(id).getCarers().stream().collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = false)
	public CarTO deleteCar(Long id) {
		if(!carRepository.exists(id)){
			return null;
		}
		CarTO car = CarMapper.toCarTO(carRepository.getOne(id));
		carRepository.delete(id);
		return car;
	}

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
		if(!(employeeService.contains(employeeId) && carRepository.exists(carId))){
			return false;
		}	
		carRepository.addCarer(carId, employeeService.findEmployeeEntityById(employeeId));
		employeeService.addCarer(employeeId, carRepository.findOne(carId));
		return true;
	}

	@Override
	public int length() {
		return carRepository.findAll().size();
	}
}
