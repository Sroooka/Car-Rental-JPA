package com.capgemini.jstk.car_rental_jpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.capgemini.jstk.car_rental_jpa.domain.impl.AbstractTimeStampEntity;
import com.capgemini.jstk.car_rental_jpa.enums.CarType;

@Entity
@Table(name = "CAR")
public class CarEntity extends AbstractTimeStampEntity implements Serializable {
	private static final long serialVersionUID = -9105240587395785572L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String manufacturer;
	
	private String model;
	
	private int productionYear;
	
	@Enumerated(EnumType.STRING) 
	private CarType carType;
	
	private String color;
	
	private int engineSize;
	
	private int power;
	
	private int mileage;
	
	@ManyToMany
    @JoinTable(name = "CAR_CARER",
            joinColumns = {@JoinColumn(name = "CAR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "EMPLOYEE_ID")}
    )
    private Collection<EmployeeEntity> carers = new ArrayList<>();
	
	@OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE)
    Set<RentalEntity> rentals = new HashSet<>();
	
	public CarEntity() {
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

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
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

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public Collection<EmployeeEntity> getCarers() {
		return carers;
	}

	public void setCarers(Collection<EmployeeEntity> carers) {
		this.carers = carers;
	}

	public Set<RentalEntity> getRentals() {
		return rentals;
	}

	public void setRentals(Set<RentalEntity> rentals) {
		this.rentals = rentals;
	}
}
