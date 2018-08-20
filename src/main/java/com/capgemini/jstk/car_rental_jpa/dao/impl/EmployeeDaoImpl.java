package com.capgemini.jstk.car_rental_jpa.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.jstk.car_rental_jpa.dao.EmployeeDao;
import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.domain.EmployeeEntity;
import com.capgemini.jstk.car_rental_jpa.enums.Position;

@Repository
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDao{

	
	@Transactional(readOnly = false)
	@Override
	public void addCarer(Long employeeId, CarEntity car) {
		EmployeeEntity employee = this.findOne(employeeId);
		Collection<CarEntity> cars = employee.getCars();
		cars.add(car);
	}

	@Override
	public List<EmployeeEntity> searchByLocation(Long locationId) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select employee from EmployeeEntity employee join employee.location loc where loc.id = :locationId", EmployeeEntity.class);
        query.setParameter("locationId", locationId);
        return query.getResultList();
	}

	@Override
	public List<EmployeeEntity> searchByCaredCars(Long carId) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select employee from EmployeeEntity employee join employee.cars cars where cars.id = :carId", EmployeeEntity.class);
        query.setParameter("carId", carId);
        return query.getResultList();
	}

	@Override
	public List<EmployeeEntity> searchByPosition(Position position) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select employee from EmployeeEntity employee where employee.position = :position", EmployeeEntity.class);
        query.setParameter("position", position);
        return query.getResultList();
	}
}
