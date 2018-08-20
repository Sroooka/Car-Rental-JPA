package com.capgemini.jstk.carrentaljpa.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.jstk.carrentaljpa.domain.CarEntity;
import com.capgemini.jstk.carrentaljpa.types.CarTO;
import com.capgemini.jstk.carrentaljpa.types.CarTO.CarTOBuilder;

public class CarMapper {
	
	public static CarTO toCarTO(CarEntity carEntity) {
		if (carEntity == null) {
			return null;
		}
		return new CarTOBuilder()
				.withId(carEntity.getId())
				.withManufacturer(carEntity.getManufacturer())
				.withModel(carEntity.getModel())
				.withProductionYear(carEntity.getProductionYear())
				.withColor(carEntity.getColor())
				.withEngineSize(carEntity.getEngineSize())
				.withPower(carEntity.getPower())
				.withCarType(carEntity.getCarType())
				.build();
	}
	
	public static CarEntity toCarEntity(CarTO carTO){
		if (carTO == null) {
			return null;
		}
		CarEntity carEntity = new CarEntity();
		carEntity.setManufacturer(carTO.getManufacturer());
		carEntity.setModel(carTO.getModel());
		carEntity.setProductionYear(carTO.getProductionYear());
		carEntity.setColor(carTO.getColor());
		carEntity.setEngineSize(carTO.getEngineSize());
		carEntity.setPower(carTO.getPower());
		carEntity.setCarType(carTO.getCarType());
		return carEntity;
	}
	
	public static List<CarTO> map2TOs(List<CarEntity> carEntities) {
		return carEntities.stream().map(CarMapper::toCarTO).collect(Collectors.toList());
	}
	
	public static List<CarEntity> map2Entities(List<CarTO> carTO) {
		return carTO.stream().map(CarMapper::toCarEntity).collect(Collectors.toList());
	}
}
