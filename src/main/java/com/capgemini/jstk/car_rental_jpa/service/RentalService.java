package com.capgemini.jstk.car_rental_jpa.service;

import com.capgemini.jstk.car_rental_jpa.domain.RentalEntity;
import com.capgemini.jstk.car_rental_jpa.types.RentalTO;

public interface RentalService {
	public RentalTO saveRental(RentalTO rental);
	public RentalTO findRentalById(Long id);
	public RentalEntity findRentalEntityById(Long id);
	public boolean contains(Long id);
}
