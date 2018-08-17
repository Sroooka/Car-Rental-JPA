package com.capgemini.jstk.car_rental_jpa.service;

import com.capgemini.jstk.car_rental_jpa.domain.LocationEntity;
import com.capgemini.jstk.car_rental_jpa.types.LocationTO;

public interface LocationService {
	public LocationTO saveLocation(LocationTO location);
	public LocationTO findLocationById(Long id);
	public LocationTO deleteLocation(Long id);
	public boolean contains(Long id);
	public LocationTO updateLocation(LocationTO updatedLocation);
	public LocationEntity findLocationEntityById(Long id);
}
