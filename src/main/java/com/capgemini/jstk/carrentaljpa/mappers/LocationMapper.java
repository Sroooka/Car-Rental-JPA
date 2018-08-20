package com.capgemini.jstk.carrentaljpa.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.jstk.carrentaljpa.domain.LocationEntity;
import com.capgemini.jstk.carrentaljpa.types.LocationTO;
import com.capgemini.jstk.carrentaljpa.types.LocationTO.LocationTOBuilder;

public class LocationMapper {
	
	public static LocationTO toLocationTO(LocationEntity locationEntity) {
		if (locationEntity == null) {
			return null;
		}
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
		if (locationTO == null) {
			return null;
		}
		LocationEntity locationEntity = new LocationEntity();
		locationEntity.setAddress(locationTO.getAddress());
		locationEntity.setCity(locationTO.getCity());
		locationEntity.setPostalCode(locationTO.getPostalCode());
		locationEntity.setPhone(locationTO.getPhone());
		locationEntity.setEmail(locationTO.getEmail());
		return locationEntity;
	}
	
	public static List<LocationTO> map2TOs(List<LocationEntity> locationEntities) {
		return locationEntities.stream().map(LocationMapper::toLocationTO).collect(Collectors.toList());
	}
	
	public static List<LocationEntity> map2Entities(List<LocationTO> locationTO) {
		return locationTO.stream().map(LocationMapper::toLocationEntity).collect(Collectors.toList());
	}
}
