package com.capgemini.jstk.car_rental_jpa.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.*;

import com.capgemini.jstk.car_rental_jpa.domain.impl.AbstractTimeStampEntity;

@Entity
@Table(name = "CAR")
public class CarEntity extends AbstractTimeStampEntity implements Serializable {
	private static final long serialVersionUID = -9105240587395785572L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String manufacturer;
	
	private String model;
	
	@Column(name = "production_year")
	private String productionYear;
	
	@ManyToOne
	private CarTypeEntity type;
	
	private String color;
	
	@Column(name = "engine_size")
	private int engineSize;
	
	private int power;
	
	private int mileage;
	
	@Column(name = "current_location")
	@ManyToOne
	private LocationEntity currentLocation;
	
	@ManyToMany
    @JoinTable(name = "CAR_CARER",
            joinColumns = {@JoinColumn(name = "CAR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "EMPLOYEE_ID")}
    )
    private Collection<EmployeeEntity> carers;
	
	@OneToMany(mappedBy = "car")
    Set<RentalEntity> rentals;
	
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

	public String getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(String productionYear) {
		this.productionYear = productionYear;
	}

	public CarTypeEntity getType() {
		return type;
	}

	public void setType(CarTypeEntity type) {
		this.type = type;
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

	public LocationEntity getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(LocationEntity currentLocation) {
		this.currentLocation = currentLocation;
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
