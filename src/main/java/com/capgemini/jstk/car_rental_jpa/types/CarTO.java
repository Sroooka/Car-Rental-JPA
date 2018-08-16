package com.capgemini.jstk.car_rental_jpa.types;

import java.time.Year;

import com.capgemini.jstk.car_rental_jpa.enums.CarType;

public class CarTO {

	private Long id;
	private String manufacturer;
	private String model;
	private int productionYear;
	private String color;
	private int engineSize;
	private int power;
	private CarType carType;

	public CarTO(Long id, String manufacturer, String model, int productionYear, String color, int engineSize,
			int power, CarType carType) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.productionYear = productionYear;
		this.color = color;
		this.engineSize = engineSize;
		this.power = power;
		this.carType = carType;
	}

	public static class CarTOBuilder {

		private Long id = 0L;
		private String manufacturer;
		private String model;
		private int productionYear;
		private String color;
		private int engineSize;
		private int power;
		private CarType carType = CarType.SEDAN;

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
		
		public CarTOBuilder withCarType(CarType carType) {
			this.carType = carType;
			return this;
		}

		public CarTO build() {
			checkBeforeBuild(manufacturer, model, productionYear, color, engineSize, power);
			return new CarTO(id, manufacturer, model, productionYear, color, engineSize, power, carType);
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
			if (power <= 0 || power > 1200)
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
		return manufacturer + " " + model + " " + carType.toString() + " [Year: " + productionYear + "] [Color: " 
				+ color + "] [Engine " + engineSize + "cm3 (" + power + "HP)]";
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}
}
