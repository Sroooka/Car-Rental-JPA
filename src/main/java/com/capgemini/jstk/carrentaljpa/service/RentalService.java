package com.capgemini.jstk.carrentaljpa.service;

import com.capgemini.jstk.carrentaljpa.domain.RentalEntity;
import com.capgemini.jstk.carrentaljpa.types.RentalTO;

public interface RentalService {
	public RentalTO saveRental(RentalTO rental);
	
	public RentalTO findRentalById(Long id);
	
	public RentalEntity findRentalEntityById(Long id);
	
	public boolean contains(Long id);
}
