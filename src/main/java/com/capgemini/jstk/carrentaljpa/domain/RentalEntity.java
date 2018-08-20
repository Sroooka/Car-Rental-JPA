package com.capgemini.jstk.carrentaljpa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.capgemini.jstk.carrentaljpa.domain.impl.AbstractTimeStampEntity;

@Entity
@Table(name = "RENTAL")
public class RentalEntity extends AbstractTimeStampEntity implements Serializable {
	private static final long serialVersionUID = -5914141166470839801L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private CustomerEntity customer;
	
	@ManyToOne
    private CarEntity car;
	
	@Temporal(TemporalType.DATE)
	private Date rentBegin;
	
	@Temporal(TemporalType.DATE)
	private Date rentEnd;
	
	@ManyToOne
    private LocationEntity startLocation;
	
    @ManyToOne
    private LocationEntity endLocation;
	
	private int cost;
	
	public RentalEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public CarEntity getCar() {
		return car;
	}

	public void setCar(CarEntity car) {
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

	public LocationEntity getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(LocationEntity startLocation) {
		this.startLocation = startLocation;
	}

	public LocationEntity getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(LocationEntity endLocation) {
		this.endLocation = endLocation;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
