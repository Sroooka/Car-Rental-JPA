package com.capgemini.jstk.car_rental_jpa.types;

import java.util.Date;

public class RentalTO {

	private Long id;
	private Date rentBegin;
	private Date rentEnd;
	private int cost;
	
	public RentalTO(Long id, Date rentBegin, Date rentEnd, int cost) {
		super();
		this.id = id;
		this.rentBegin = rentBegin;
		this.rentEnd = rentEnd;
		this.cost = cost;
	}

	public static class RentalTOBuilder {
		private Long id;
		private Date rentBegin;
		private Date rentEnd;
		private int cost;
		
		public RentalTOBuilder() {
			super();
		}
		
		public RentalTOBuilder withId(Long id) {
			this.id = id;
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
		
		public RentalTOBuilder withCost(int cost) {
			this.cost = cost;
			return this;
		}
		
		public RentalTO build() {
			checkBeforeBuild(rentBegin, rentEnd, cost);
			return new RentalTO(id, rentBegin, rentEnd, cost);
		}
		
		private void checkBeforeBuild(Date rentBegin, Date rentEnd, int cost) {		
			if (rentBegin == null || rentEnd == null)
			{
				throw new RuntimeException("Incorrect Rent Time to be created!");
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
