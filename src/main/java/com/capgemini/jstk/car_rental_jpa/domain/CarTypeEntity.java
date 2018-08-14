package com.capgemini.jstk.car_rental_jpa.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.capgemini.jstk.car_rental_jpa.domain.impl.AbstractTimeStampEntity;

@Entity
@Table(name = "CAR_TYPE")
public class CarTypeEntity extends AbstractTimeStampEntity implements Serializable {
	private static final long serialVersionUID = -5661195561786386118L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;

	@OneToMany(mappedBy = "type")
    Set<CarEntity> cars;
	
	public CarTypeEntity() {
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

	public Set<CarEntity> getCars() {
		return cars;
	}

	public void setCars(Set<CarEntity> cars) {
		this.cars = cars;
	}
}
