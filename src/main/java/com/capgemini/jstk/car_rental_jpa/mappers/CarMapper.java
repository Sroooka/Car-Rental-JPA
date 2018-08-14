package com.capgemini.jstk.car_rental_jpa.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.types.CarTO;
import com.capgemini.jstk.car_rental_jpa.types.CarTO.CarTOBuilder;

public class CarMapper {
	public static CarTO toCarTO(CarEntity carEntity) {
		if (carEntity == null)
			return null;
		return new CarTOBuilder()
				.withManufacturer(carEntity.getManufacturer())
				.withModel(carEntity.getModel())
				.withProductionYear(carEntity.getProductionYear())
				.withColor(carEntity.getColor())
				.withEngineSize(carEntity.getEngineSize())
				.withPower(carEntity.getPower())
				.build();
	}
	
	public static CarEntity toCarEntity(CarTO carTO){
		if (carTO == null)
			return null;
		CarEntity carEntity = new CarEntity();
		carEntity.setId(carTO.getId());
		carEntity.setManufacturer(carTO.getManufacturer());
		carEntity.setModel(carTO.getModel());
		carEntity.setProductionYear(carTO.getProductionYear());
		carEntity.setColor(carTO.getColor());
		carEntity.setEngineSize(carTO.getEngineSize());
		carEntity.setPower(carTO.getPower());
		return carEntity;
	}
	
	public static Set<CarTO> map2TOs(Set<CarEntity> carEntities) {
		return carEntities.stream().map(CarMapper::toCarTO).collect(Collectors.toSet());
	}
	
	public static Set<CarEntity> map2Entities(Set<CarTO> carTO) {
		return carTO.stream().map(CarMapper::toCarEntity).collect(Collectors.toSet());
	}
}
