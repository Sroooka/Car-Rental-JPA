package com.capgemini.jstk.car_rental_jpa.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.capgemini.jstk.car_rental_jpa.domain.impl.AbstractTimeStampEntity;

@Entity
@Table(name = "LOCATION")
public class LocationEntity extends AbstractTimeStampEntity implements Serializable {
	private static final long serialVersionUID = -3109391004768381617L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String address;
	
	private String city;
	
	private String postalCode;
	
	private String phone;
	
	private String email;

	@OneToMany(mappedBy = "location")
    Set<EmployeeEntity> employee;
	
    @OneToMany(mappedBy = "startLocation")
    Set<RentalEntity> startRentals;

    @OneToMany(mappedBy = "endLocation")
    Set<RentalEntity> endRentals;
	
	public LocationEntity() {
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

	public Set<EmployeeEntity> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<EmployeeEntity> employee) {
		this.employee = employee;
	}

	public Set<RentalEntity> getStartRentals() {
		return startRentals;
	}

	public void setStartRentals(Set<RentalEntity> startRentals) {
		this.startRentals = startRentals;
	}

	public Set<RentalEntity> getEndRentals() {
		return endRentals;
	}

	public void setEndRentals(Set<RentalEntity> endRentals) {
		this.endRentals = endRentals;
	}
}
