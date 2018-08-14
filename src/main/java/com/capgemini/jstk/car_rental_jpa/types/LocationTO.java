package com.capgemini.jstk.car_rental_jpa.types;

public class LocationTO {

	private Long id;
	private String address;
	private String city;
	private String postalCode;
	private String phone;
	private String email;
	
	public LocationTO(Long id, String address, String city, String postalCode, String phone, String email) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.phone = phone;
		this.email = email;
	}
	
	public static class LocationTOBuilder {
		private Long id = 0L;
		private String address;
		private String city;
		private String postalCode;
		private String phone;
		private String email;
		
		public LocationTOBuilder() {
			super();
		}
		
		public LocationTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}
		
		public LocationTOBuilder withAddress(String address) {
			this.address = address;
			return this;
		}
		
		public LocationTOBuilder withCity(String city) {
			this.city = city;
			return this;
		}
		
		public LocationTOBuilder withPostalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}
		
		public LocationTOBuilder withPhone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public LocationTOBuilder withEmail(String email) {
			this.email = email;
			return this;
		}
		
		public LocationTO build() {
			checkBeforeBuild(address, city, postalCode, phone, email);
			return new LocationTO(id, address, city, postalCode, phone, email);
		}
		
		private void checkBeforeBuild(String address, String city, String postalCode, String phone, String email) {		
			if (address == null || address.isEmpty() ||
				city == null || city.isEmpty() ||
				postalCode == null || postalCode.isEmpty())
			{
				throw new RuntimeException("Incorrect Address to be created!");
			}
			if (phone == null || phone.isEmpty() ||
				email == null || email.isEmpty())
			{
				throw new RuntimeException("Incorrect Contact data to be created!");
			}
		}
	}
	
	@Override
	public String toString() {
		return "Location: <" + postalCode + "> " + city + ", " + address + ", Tel. " + phone + "Mail " + email;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
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
		LocationTO other = (LocationTO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
