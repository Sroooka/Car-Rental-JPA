package com.capgemini.jstk.car_rental_jpa.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import com.capgemini.jstk.car_rental_jpa.domain.CustomerEntity;
import com.capgemini.jstk.car_rental_jpa.types.CustomerTO.CustomerTOBuilder;
import com.capgemini.jstk.car_rental_jpa.types.CustomerTO;

public class CustomerMapper {
	public static CustomerTO toCustomerTO(CustomerEntity customerEntity) {
		if (customerEntity == null)
			return null;
		return new CustomerTOBuilder()
				.withName(customerEntity.getName())
				.withSurname(customerEntity.getSurname())
				.withAddress(customerEntity.getAddress())
				.withCity(customerEntity.getCity())
				.withPostalCode(customerEntity.getPostalCode())
				.build();
	}
	
	public static CustomerEntity toCustomerEntity(CustomerTO customerTO){
		if (customerTO == null)
			return null;
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setName(customerTO.getName());
		customerEntity.setSurname(customerTO.getSurname());
		customerEntity.setAddress(customerTO.getAddress());
		customerEntity.setCity(customerTO.getCity());
		customerEntity.setPostalCode(customerTO.getPostalCode());
		return customerEntity;
	}
	
	public static Set<CustomerTO> map2TOs(Set<CustomerEntity> customerEntities) {
		return customerEntities.stream().map(CustomerMapper::toCustomerTO).collect(Collectors.toSet());
	}
	
	public static Set<CustomerEntity> map2Entities(Set<CustomerTO> customerTO) {
		return customerTO.stream().map(CustomerMapper::toCustomerEntity).collect(Collectors.toSet());
	}
}
