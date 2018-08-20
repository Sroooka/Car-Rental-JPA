package com.capgemini.jstk.carrentaljpa.types;

import com.capgemini.jstk.carrentaljpa.enums.Position;

public class EmployeeTO {

	private Long id = 0L;
	
	private String name;
	
	private String surname;
	
	private Position position;

	public EmployeeTO() {
		super();
	}
	
	public EmployeeTO(String name, String surname, Position position) {
		super();
		this.name = name;
		this.surname = surname;
		this.position = position;
	}

	public EmployeeTO(Long id, String name, String surname, Position position) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.position = position;
	}
	
	@Override
	public String toString() {
		return name + " " + surname + "[" + position + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		EmployeeTO other = (EmployeeTO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
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

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
