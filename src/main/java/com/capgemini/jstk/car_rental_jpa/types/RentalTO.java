package com.capgemini.jstk.car_rental_jpa.types;

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
		
		public RentalTOBuilder withCustomer(CustomerTO customer) {
			this.customer = customer;
			return this;
		}
		
		public RentalTOBuilder withCar(CarTO car) {
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
		
		public RentalTOBuilder withStartLocation(LocationTO startLocation) {
			this.startLocation = startLocation;
			return this;
		}
		
		public RentalTOBuilder withEndLocation(LocationTO endLocation) {
			this.endLocation = endLocation;
			return this;
		}
		
		public RentalTOBuilder withCost(int cost) {
			this.cost = cost;
			return this;
		}
		
		public RentalTO build() {
			checkBeforeBuild(customer, car, rentBegin, rentEnd, startLocation, endLocation, cost);
			return new RentalTO(id, customer, car, rentBegin, rentEnd, startLocation, endLocation, cost);
		}
		
		private void checkBeforeBuild(CustomerTO customer, CarTO car, Date rentBegin, Date rentEnd, LocationTO startLocation,
				LocationTO endLocation, int cost) {		
			if (customer == null)
			{
				throw new RuntimeException("Incorrect Customer to be created!");
			}
			if (car == null)
			{
				throw new RuntimeException("Incorrect Car to be created!");
			}
			if (rentBegin == null || rentEnd == null)
			{
				throw new RuntimeException("Incorrect Rent Time to be created!");
			}
			if (startLocation == null || endLocation == null)
			{
				throw new RuntimeException("Incorrect Location to be created!");
			}
			if (cost<0)
			{
				throw new RuntimeException("Incorrect Cost to be created!");
			}
		}
	}
}
