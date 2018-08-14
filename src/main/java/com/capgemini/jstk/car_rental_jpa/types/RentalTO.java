package com.capgemini.jstk.car_rental_jpa.types;

import java.util.Date;

public class RentalTO {

	private Long id;
	private Long customerId;
    private Long carId;
	private Date rentBegin;
	private Date rentEnd;
    private Long startLocationId;
    private Long endLocationId;
	private int cost;
	
	public RentalTO(Long id, Long customerId, Long carId, Date rentBegin, Date rentEnd, Long startLocationId,
			Long endLocationId, int cost) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.carId = carId;
		this.rentBegin = rentBegin;
		this.rentEnd = rentEnd;
		this.startLocationId = startLocationId;
		this.endLocationId = endLocationId;
		this.cost = cost;
	}

	public static class RentalTOBuilder {
		private Long id;
		private Long customerId;
	    private Long carId;
		private Date rentBegin;
		private Date rentEnd;
	    private Long startLocationId;
	    private Long endLocationId;
		private int cost;
		
		public RentalTOBuilder() {
			super();
		}
		
		public RentalTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}
		
		public RentalTOBuilder withCustomerId(Long customerId) {
			this.customerId = customerId;
			return this;
		}
		
		public RentalTOBuilder withCarId(Long carId) {
			this.carId = carId;
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
		
		public RentalTOBuilder withStartLocationId(Long startLocationId) {
			this.startLocationId = startLocationId;
			return this;
		}
		
		public RentalTOBuilder withEndLocationId(Long endLocationId) {
			this.endLocationId = endLocationId;
			return this;
		}
		
		public RentalTOBuilder withCost(int cost) {
			this.cost = cost;
			return this;
		}
		
		public RentalTO build() {
			checkBeforeBuild(customerId, carId, rentBegin, rentEnd, startLocationId, endLocationId, cost);
			return new RentalTO(id, customerId, carId, rentBegin, rentEnd, startLocationId, endLocationId, cost);
		}
		
		private void checkBeforeBuild(Long customerId, Long carId, Date rentBegin, Date rentEnd, Long startLocationId,
				Long endLocationId, int cost) {		
			if (customerId <= 0)
			{
				throw new RuntimeException("Incorrect Customer ID to be created!");
			}
			if (carId <= 0)
			{
				throw new RuntimeException("Incorrect Car ID to be created!");
			}
			if (rentBegin == null || rentEnd == null)
			{
				throw new RuntimeException("Incorrect Rent Time to be created!");
			}
			if (startLocationId <= 0 || endLocationId <= 0)
			{
				throw new RuntimeException("Incorrect LocationId to be created!");
			}
			if (cost<0)
			{
				throw new RuntimeException("Incorrect Cost to be created!");
			}
		}
	}
	
	@Override
	public String toString() {
		//TODO UPDATE WHEN SERVICE IS FINISHED
		return "CarID: " + carId + ", Rent Begin: " + rentBegin + ", Rent End: " + rentEnd +
				", StartLocationID: " + startLocationId + ", EndLocationID: " + endLocationId +
				", Cost: " + cost;
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
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

	public Long getStartLocationId() {
		return startLocationId;
	}

	public void setStartLocationId(Long startLocationId) {
		this.startLocationId = startLocationId;
	}

	public Long getEndLocationId() {
		return endLocationId;
	}

	public void setEndLocationId(Long endLocationId) {
		this.endLocationId = endLocationId;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
