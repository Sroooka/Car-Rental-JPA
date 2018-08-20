package com.capgemini.jstk.carrentaljpa.types;

import java.util.Date;

public class RentalTO {

	private Long id;
	
	private CustomerTO customer;
	
	private CarTO car;
	
	private Date rentBegin;
	
	private Date rentEnd;
	
	private LocationTO startLocation;
	
	private LocationTO endLocation;
	
	private int cost;

	public RentalTO(Long id, CustomerTO customer, CarTO car, Date rentBegin, Date rentEnd, LocationTO startLocation,
			LocationTO endLocation, int cost) {
		super();
		this.id = id;
		this.customer = customer;
		this.car = car;
		this.rentBegin = rentBegin;
		this.rentEnd = rentEnd;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.cost = cost;
	}

	public static class RentalTOBuilder {
		
		private Long id;
		
		private CustomerTO customer;
		
		private CarTO car;
		
		private Date rentBegin;
		
		private Date rentEnd;
		
		private LocationTO startLocation;
		
		private LocationTO endLocation;
		
		private int cost;
		
		public RentalTOBuilder() {
			super();
		}
		
		public RentalTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}
		
		public RentalTOBuilder withCustomer(CustomerTO customer){
			this.customer = customer;
			return this;
		}
		
		public RentalTOBuilder withCar(CarTO car){
			this.car = car;
			return this;
		}
		
		public RentalTOBuilder withRentBegin(Date rentBegin) {
			this.rentBegin = rentBegin;
			return this;
		}
		
		public RentalTOBuilder withRentEnd(Date rentEnd) {
			this.rentEnd = rentEnd;
			return this;
		}
		
		public RentalTOBuilder withStartLocation(LocationTO startLocation){
			this.startLocation = startLocation;
			return this;
		}
		
		public RentalTOBuilder withEndLocation(LocationTO endLocation){
			this.endLocation = endLocation;
			return this;
		}
		
		public RentalTOBuilder withCost(int cost) {
			this.cost = cost;
			return this;
		}
		
		public RentalTO build() {
			checkBeforeBuild(rentBegin, rentEnd, customer, car, startLocation, endLocation, cost);
			return new RentalTO(id, customer, car, rentBegin, rentEnd, startLocation, endLocation, cost);
		}
		
		private void checkBeforeBuild(Date rentBegin, Date rentEnd, CustomerTO customer, CarTO car, LocationTO startLocation, LocationTO endLocation, int cost) {		
			if (customer == null)
			{
				throw new RuntimeException("Incorrect Customer to be created!");
			}
			if (car == null)
			{
				throw new RuntimeException("Incorrect Customer to be created!");
			}
			if (rentBegin == null || rentEnd == null)
			{
				throw new RuntimeException("Incorrect Rent Time to be created!");
			}
			if (startLocation == null || endLocation == null)
			{
				throw new RuntimeException("Incorrect Locations to be created!");
			}
			if (cost<0)
			{
				throw new RuntimeException("Incorrect Cost to be created!");
			}
		}
	}
	
	@Override
	public String toString() {
		String idText = (id == 0) ? "No ID! / " : "ID: " + id;
		return idText + " Rent Begin: " + rentBegin + ", Rent End: " + rentEnd + ", Cost: " + cost;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rentBegin == null) ? 0 : rentBegin.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rentEnd == null) ? 0 : rentEnd.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentalTO other = (RentalTO) obj;
		if (rentBegin == null) {
			if (other.rentBegin != null)
				return false;
		} else if (!rentBegin.equals(other.rentBegin))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rentEnd == null) {
			if (other.rentEnd != null)
				return false;
		} else if (!rentEnd.equals(other.rentEnd))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerTO customer) {
		this.customer = customer;
	}

	public CarTO getCar() {
		return car;
	}

	public void setCar(CarTO car) {
		this.car = car;
	}

	public Date getRentBegin() {
		return rentBegin;
	}

	public void setRentBegin(Date rentBegin) {
		this.rentBegin = rentBegin;
	}

	public Date getRentEnd() {
		return rentEnd;
	}

	public void setRentEnd(Date rentEnd) {
		this.rentEnd = rentEnd;
	}

	public LocationTO getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(LocationTO startLocation) {
		this.startLocation = startLocation;
	}

	public LocationTO getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(LocationTO endLocation) {
		this.endLocation = endLocation;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
