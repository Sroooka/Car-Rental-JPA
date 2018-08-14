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
@Table(name = "POSITION")
public class PositionEntity extends AbstractTimeStampEntity implements Serializable {
	private static final long serialVersionUID = -825418917382252951L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "position")
    Set<EmployeeEntity> employee;

	public PositionEntity() {
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

	public Set<EmployeeEntity> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<EmployeeEntity> employee) {
		this.employee = employee;
	}
}
