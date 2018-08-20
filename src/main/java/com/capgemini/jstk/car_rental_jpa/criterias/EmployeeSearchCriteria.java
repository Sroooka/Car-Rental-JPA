package com.capgemini.jstk.car_rental_jpa.criterias;

import com.capgemini.jstk.car_rental_jpa.enums.Position;
import com.capgemini.jstk.car_rental_jpa.types.CarTO;
import com.capgemini.jstk.car_rental_jpa.types.LocationTO;

public class EmployeeSearchCriteria {
	LocationTO location;
	CarTO caredCar;
	Position position;

	public EmployeeSearchCriteria() {
		super();
	}

	public EmployeeSearchCriteria(LocationTO location, CarTO caredCar, Position position) {
		super();
		this.location = location;
		this.caredCar = caredCar;
		this.position = position;
	}

	public static class EmployeeSearchCriteriaBuilder {
		LocationTO location = null;
		CarTO caredCar = null;
		Position position = null;
		
		public EmployeeSearchCriteriaBuilder(){
			super();
		}
		
		public EmployeeSearchCriteriaBuilder withLocation(LocationTO location) {
			this.location = location;
			return this;
		}
		
		public EmployeeSearchCriteriaBuilder withCaredCar(CarTO caredCar) {
			this.caredCar = caredCar;
			return this;
		}
		
		public EmployeeSearchCriteriaBuilder withPosition(Position position) {
			this.position = position;
			return this;
		}
		
		public EmployeeSearchCriteria build(){
			return new EmployeeSearchCriteria(location, caredCar, position);
		}
	}

	public LocationTO getLocation() {
		return location;
	}

	public void setLocation(LocationTO location) {
		this.location = location;
	}

	public CarTO getCaredCar() {
		return caredCar;
	}

	public void setCaredCar(CarTO caredCar) {
		this.caredCar = caredCar;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
