package com.capgemini.jstk.carrentaljpa.types;

public class CustomerTO {

	private Long id;
	
	private String name;
	
	private String surname;
	
	private String address;
	
	private String city;
	
	private String postalCode;
	
	public CustomerTO(Long id, String name, String surname, String address, String city, String postalCode) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
	}
	public static class CustomerTOBuilder {
		
		private Long id = 0L;
		
		private String name;
		
		private String surname;
		
		private String address;
		
		private String city;
		
		private String postalCode;
		
		public CustomerTOBuilder() {
			super();
		}
		
		public CustomerTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}
		
		public CustomerTOBuilder withName(String name) {
			this.name = name;
			return this;
		}
		
		public CustomerTOBuilder withSurname(String surname) {
			this.surname = surname;
			return this;
		}
		
		public CustomerTOBuilder withAddress(String address) {
			this.address = address;
			return this;
		}
		
		public CustomerTOBuilder withCity(String city) {
			this.city = city;
			return this;
		}
		
		public CustomerTOBuilder withPostalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}
		
		public CustomerTO build() {
			checkBeforeBuild(name, surname, address, city, postalCode);
			return new CustomerTO(id, name, surname, address, city, postalCode);
		}
		
		private void checkBeforeBuild(String name, String surname, String address, String city, String postalCode) {		
			if (name == null || name.isEmpty() ||
				surname == null || surname.isEmpty())
			{
				throw new RuntimeException("Incorrect Customer personal data to be created!");
			}
			if (address == null || address.isEmpty() ||
				city == null || city.isEmpty() ||
				postalCode == null || postalCode.isEmpty())
			{
				throw new RuntimeException("Incorrect Customer address to be created!");
			}
		}
	}
	
	@Override
	public String toString() {
		return name + " " + surname + "[Address: " + address + ", <" + postalCode + "> "+ city;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		CustomerTO other = (CustomerTO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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
}
