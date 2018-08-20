package com.capgemini.jstk.car_rental_jpa.criterias;

import com.capgemini.jstk.car_rental_jpa.enums.Position;

public class EmployeeSearchCriteria {
	Long locationId;
	Long caredCarId;
	Position position;

	public EmployeeSearchCriteria() {
		super();
	}

	public EmployeeSearchCriteria(Long locationId, Long caredCarId, Position position) {
		super();
		this.locationId = locationId;
		this.caredCarId = caredCarId;
		this.position = position;
	}

	public static class EmployeeSearchCriteriaBuilder {
		Long locationId;
		Long caredCarId;
		Position position;
		
		public EmployeeSearchCriteriaBuilder(){
			super();
		}
		
		public EmployeeSearchCriteriaBuilder withLocationId(Long locationId) {
			this.locationId = locationId;
			return this;
		}
		
		public EmployeeSearchCriteriaBuilder withCaredCarId(Long caredCarId) {
			this.caredCarId = caredCarId;
			return this;
		}
		
		public EmployeeSearchCriteriaBuilder withPosition(Position position) {
			this.position = position;
			return this;
		}
		
		public EmployeeSearchCriteria build(){
			return new EmployeeSearchCriteria(locationId, caredCarId, position);
		}
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Long getCaredCarId() {
		return caredCarId;
	}

	public void setCaredCarId(Long caredCarId) {
		this.caredCarId = caredCarId;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
