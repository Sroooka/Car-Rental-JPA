package com.capgemini.jstk.car_rental_jpa.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.jstk.car_rental_jpa.domain.RentalEntity;
import com.capgemini.jstk.car_rental_jpa.types.RentalTO;
import com.capgemini.jstk.car_rental_jpa.types.RentalTO.RentalTOBuilder;


public class RentalMapper {
	
	public static RentalTO toRentalTO(RentalEntity rentalEntity) {
		if (rentalEntity == null)
			return null;
		return new RentalTOBuilder()
				.withId(rentalEntity.getId())
				.withCustomer(CustomerMapper.toCustomerTO(rentalEntity.getCustomer()))
				.withCar(CarMapper.toCarTO(rentalEntity.getCar()))
				.withRentBegin(rentalEntity.getRentBegin())
				.withRentEnd(rentalEntity.getRentEnd())
				.withStartLocation(LocationMapper.toLocationTO(rentalEntity.getStartLocation()))
				.withEndLocation(LocationMapper.toLocationTO(rentalEntity.getEndLocation()))
				.withCost(rentalEntity.getCost())
				.build();
	}
	
	public static RentalEntity toRentalEntity(RentalTO rentalTO){
		if (rentalTO == null)
			return null;
		RentalEntity rentalEntity = new RentalEntity();
		rentalEntity.setCustomer(CustomerMapper.toCustomerEntity(rentalTO.getCustomer()));
		rentalEntity.setCar(CarMapper.toCarEntity(rentalTO.getCar()));
		rentalEntity.setRentBegin(rentalTO.getRentBegin());
		rentalEntity.setRentEnd(rentalTO.getRentEnd());
		rentalEntity.setStartLocation(LocationMapper.toLocationEntity(rentalTO.getStartLocation()));
		rentalEntity.setEndLocation(LocationMapper.toLocationEntity(rentalTO.getEndLocation()));
		rentalEntity.setCost(rentalTO.getCost());
		return rentalEntity;
	}
	
	public static List<RentalTO> map2TOs(List<RentalEntity> rentalEntities) {
		return rentalEntities.stream().map(RentalMapper::toRentalTO).collect(Collectors.toList());
	}
	
	public static List<RentalEntity> map2Entities(List<RentalTO> rentalTO) {
		return rentalTO.stream().map(RentalMapper::toRentalEntity).collect(Collectors.toList());
	}
}
