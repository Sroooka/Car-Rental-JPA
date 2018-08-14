package com.capgemini.jstk.car_rental_jpa.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.capgemini.jstk.car_rental_jpa.domain.impl.AbstractTimeStampEntity;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity extends AbstractTimeStampEntity implements Serializable {
	private static final long serialVersionUID = -7431211723205099196L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String surname;
	
	private String address;
	
	private String city;
	
	private String postalCode;
	
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	private String phone;
	
	private String email;
	
	private String creditCardNumber;
	
	@OneToMany(mappedBy = "customers")
    Set<RentalEntity> rentals;
	
	public CustomerEntity() {
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Set<RentalEntity> getRentals() {
		return rentals;
	}

	public void setRentals(Set<RentalEntity> rentals) {
		this.rentals = rentals;
	}
}
