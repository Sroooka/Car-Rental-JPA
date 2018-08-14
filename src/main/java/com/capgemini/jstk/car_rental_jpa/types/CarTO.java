package com.capgemini.jstk.car_rental_jpa.types;

import java.time.Year;

public class CarTO {

	private Long id;
	private String manufacturer;
	private String model;
	private int productionYear;
	private String color;
	private int engineSize;
	private int power;

	public CarTO(Long id, String manufacturer, String model, int productionYear, String color, int engineSize,
			int power) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.productionYear = productionYear;
		this.color = color;
		this.engineSize = engineSize;
		this.power = power;
	}

	public static class CarTOBuilder {

		private Long id = 0L;
		private String manufacturer;
		private String model;
		private int productionYear;
		private String color;
		private int engineSize;
		private int power;

		public CarTOBuilder() {
			super();
		}

		public CarTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public CarTOBuilder withManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
			return this;
		}

		public CarTOBuilder withModel(String model) {
			this.model = model;
			return this;
		}

		public CarTOBuilder withProductionYear(int productionYear) {
			this.productionYear = productionYear;
			return this;
		}

		public CarTOBuilder withColor(String color) {
			this.color = color;
			return this;
		}

		public CarTOBuilder withEngineSize(int engineSize) {
			this.engineSize = engineSize;
			return this;
		}

		public CarTOBuilder withPower(int power) {
			this.power = power;
			return this;
		}

		public CarTO build() {
			checkBeforeBuild(manufacturer, model, productionYear, color, engineSize, power);
			return new CarTO(id, manufacturer, model, productionYear, color, engineSize, power);
		}

		private void checkBeforeBuild(String manufacturer, String model, int productionYear, String color,
				int engineSize, int power) {		
			
			if (manufacturer == null || manufacturer.isEmpty())
			{
				throw new RuntimeException("Incorrect Manufacturer to be created!");
			}
			if (model == null || model.isEmpty())
			{
				throw new RuntimeException("Incorrect Model to be created!");
			}
			if (color == null || color.isEmpty())
			{
				throw new RuntimeException("Incorrect Color to be created!");
			}
			if (engineSize <= 500 || engineSize >= 7000)
			{
				throw new RuntimeException("Incorrect Engine Size to be created!");
			}
			if (power < 0 || power > 1200)
			{
				throw new RuntimeException("Incorrect Power to be created!");
			}
			if (productionYear < 1950 || 
				productionYear > (Year.now().getValue() + 1)) //not higher than current year+1
			{
				throw new RuntimeException("Incorrect Production Year to be created!");
			}
		}
	}
	
	@Override
	public String toString() {
		return manufacturer + " " + model + " " + ", Year: " + productionYear + ", Color: " 
				+ color + ", Engine " + engineSize + "cm3 (" + power + "HP).";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
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
		CarTO other = (CarTO) obj;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}
}
