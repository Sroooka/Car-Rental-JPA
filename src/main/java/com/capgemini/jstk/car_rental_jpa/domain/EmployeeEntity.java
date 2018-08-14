package com.capgemini.jstk.car_rental_jpa.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.capgemini.jstk.car_rental_jpa.domain.impl.AbstractTimeStampEntity;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity extends AbstractTimeStampEntity implements Serializable {
	private static final long serialVersionUID = -27085028186627959L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String surname;
	
	@ManyToOne
	private PositionEntity position;
	
	private Date birth;
	
	@ManyToOne
	private LocationEntity location;
	
	@ManyToMany (mappedBy = "carers")
	private Collection<CarEntity> cars;
	
	public EmployeeEntity() {
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

	public PositionEntity getPosition() {
		return position;
	}

	public void setPosition(PositionEntity position) {
		this.position = position;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public LocationEntity getLocation() {
		return location;
	}

	public void setLocation(LocationEntity location) {
		this.location = location;
	}

	public Collection<CarEntity> getCars() {
		return cars;
	}

	public void setCars(Collection<CarEntity> cars) {
		this.cars = cars;
	}
}
