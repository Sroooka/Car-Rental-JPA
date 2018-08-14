package com.capgemini.jstk.car_rental_jpa.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import com.capgemini.jstk.car_rental_jpa.domain.LocationEntity;
import com.capgemini.jstk.car_rental_jpa.types.LocationTO;
import com.capgemini.jstk.car_rental_jpa.types.LocationTO.LocationTOBuilder;

public class LocationMapper {
	
	public static LocationTO toLocationTO(LocationEntity locationEntity) {
		if (locationEntity == null)
			return null;
		return new LocationTOBuilder()
				.withId(locationEntity.getId())
				.withAddress(locationEntity.getAddress())
				.withCity(locationEntity.getCity())
				.withPostalCode(locationEntity.getPostalCode())
				.withPhone(locationEntity.getPhone())
				.withEmail(locationEntity.getEmail())
				.build();
	}
	
	public static LocationEntity toLocationEntity(LocationTO locationTO){
		if (locationTO == null)
			return null;
		LocationEntity locationEntity = new LocationEntity();
		locationEntity.setId(locationTO.getId());
		locationEntity.setAddress(locationTO.getAddress());
		locationEntity.setCity(locationTO.getCity());
		locationEntity.setPostalCode(locationTO.getPostalCode());
		locationEntity.setPhone(locationTO.getPhone());
		locationEntity.setEmail(locationTO.getEmail());
		return locationEntity;
	}
	
	public static Set<LocationTO> map2TOs(Set<LocationEntity> locationEntities) {
		return locationEntities.stream().map(LocationMapper::toLocationTO).collect(Collectors.toSet());
	}
	
	public static Set<LocationEntity> map2Entities(Set<LocationTO> locationTO) {
		return locationTO.stream().map(LocationMapper::toLocationEntity).collect(Collectors.toSet());
	}
}
