package com.capgemini.jstk.car_rental_jpa.mappers;

import java.util.Set;
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
				.withCustomerId(rentalEntity.getCustomer().getId())
				.withCarId(rentalEntity.getCar().getId())
				.withRentBegin(rentalEntity.getRentBegin())
				.withRentEnd(rentalEntity.getRentEnd())
				.withStartLocationId(rentalEntity.getStartLocation().getId())
				.withEndLocationId(rentalEntity.getEndLocation().getId())
				.withCost(rentalEntity.getCost())
				.build();
	}
	
	public static RentalEntity toRentalEntity(RentalTO rentalTO){
		if (rentalTO == null)
			return null;
		RentalEntity rentalEntity = new RentalEntity();
		rentalEntity.setId(rentalTO.getId());
		rentalEntity.setCustomer(null); 							//TODO
		rentalEntity.setCar(null);									//TODO
		rentalEntity.setRentBegin(rentalTO.getRentBegin());
		rentalEntity.setRentEnd(rentalTO.getRentEnd());
		rentalEntity.setStartLocation(null);						//TODO
		rentalEntity.setEndLocation(null);							//TODO
		return rentalEntity;
	}
	
	public static Set<RentalTO> map2TOs(Set<RentalEntity> rentalEntities) {
		return rentalEntities.stream().map(RentalMapper::toRentalTO).collect(Collectors.toSet());
	}
	
	public static Set<RentalEntity> map2Entities(Set<RentalTO> rentalTO) {
		return rentalTO.stream().map(RentalMapper::toRentalEntity).collect(Collectors.toSet());
	}
}
