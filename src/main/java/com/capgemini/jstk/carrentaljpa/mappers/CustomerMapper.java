package com.capgemini.jstk.carrentaljpa.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.jstk.carrentaljpa.domain.CustomerEntity;
import com.capgemini.jstk.carrentaljpa.types.CustomerTO.CustomerTOBuilder;
import com.capgemini.jstk.carrentaljpa.types.CustomerTO;

public class CustomerMapper {
	public static CustomerTO toCustomerTO(CustomerEntity customerEntity) {
		if (customerEntity == null) {
			return null;
		}
		return new CustomerTOBuilder()
				.withId(customerEntity.getId())
				.withName(customerEntity.getName())
				.withSurname(customerEntity.getSurname())
				.withAddress(customerEntity.getAddress())
				.withCity(customerEntity.getCity())
				.withPostalCode(customerEntity.getPostalCode())
				.build();
	}
	
	public static CustomerEntity toCustomerEntity(CustomerTO customerTO){
		if (customerTO == null) {
			return null;
		}
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setName(customerTO.getName());
		customerEntity.setSurname(customerTO.getSurname());
		customerEntity.setAddress(customerTO.getAddress());
		customerEntity.setCity(customerTO.getCity());
		customerEntity.setPostalCode(customerTO.getPostalCode());
		return customerEntity;
	}
	
	public static List<CustomerTO> map2TOs(List<CustomerEntity> customerEntities) {
		return customerEntities.stream().map(CustomerMapper::toCustomerTO).collect(Collectors.toList());
	}
	
	public static List<CustomerEntity> map2Entities(List<CustomerTO> customerTO) {
		return customerTO.stream().map(CustomerMapper::toCustomerEntity).collect(Collectors.toList());
	}
}
