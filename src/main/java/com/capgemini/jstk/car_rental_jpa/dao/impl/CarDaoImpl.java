package com.capgemini.jstk.car_rental_jpa.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.capgemini.jstk.car_rental_jpa.dao.CarDao;
import com.capgemini.jstk.car_rental_jpa.domain.CarEntity;
import com.capgemini.jstk.car_rental_jpa.domain.EmployeeEntity;
import com.capgemini.jstk.car_rental_jpa.enums.CarType;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao{

	@Override
	public List<CarEntity> findCarsByManufacturer(String manufacturer) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where upper(car.manufacturer) like concat(upper(:manufacturer), '%')", CarEntity.class);
        query.setParameter("manufacturer", manufacturer);
        return query.getResultList();
	}

	@Override
	public List<CarEntity> findCarsByModel(String model) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where upper(car.model) like concat(upper(:model), '%')", CarEntity.class);
        query.setParameter("model", model);
        return query.getResultList();
	}

	@Override
	public List<CarEntity> findCarsByProductionYear(int productionYear) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where car.productionYear = :productionYear", CarEntity.class);
        query.setParameter("productionYear", productionYear);
        return query.getResultList();
	}

	@Override
	public List<CarEntity> findCarsByCarType(CarType carType) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where car.carType = :carType", CarEntity.class);
        query.setParameter("carType", carType);
        return query.getResultList();
	}

	@Override
	public void addCarer(Long carId, EmployeeEntity carer) {
		CarEntity car = this.findOne(carId);
		Collection<EmployeeEntity> employees = car.getCarers();
		employees.add(carer);
	}

	@Override
	public List<CarEntity> findCarsByCarer(Long carerId) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
                "select distinct car from CarEntity car join car.carers carer where carer.id = :carerId", CarEntity.class);
        query.setParameter("carerId", carerId);
        return query.getResultList();
	}

	@Override
	public List<CarEntity> findCarByCarTypeAndManufacturer(CarType carType, String manufacturer) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CarEntity> cq = cb.createQuery(CarEntity.class);
        Root<CarEntity> car = cq.from(CarEntity.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        ParameterExpression<String> p1 = cb.parameter(String.class);
        ParameterExpression<CarType> p2 = cb.parameter(CarType.class); 
        predicates.add(cb.like(car.get("manufacturer"), p1));
        predicates.add(cb.equal(car.get("carType"), p2));
        cq.select(car)
        	.where(predicates.toArray(new Predicate[]{}));
        TypedQuery<CarEntity> q = entityManager.createQuery(cq);
        q.setParameter(p1, manufacturer);
        q.setParameter(p2, carType);
        return q.getResultList();
	}

	@Override
	public List<CarEntity> findCarsRentedByMoreThanExpectedPeople(int i) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
                	"select car from CarEntity car " 
                + 	"where car.id in ("
                + 		"select rentals.car.id from RentalEntity rentals " 
                +		"group by rentals.car.id " 
                +		"having count(distinct rentals.customer.id) >= :amount)"
            		,CarEntity.class);
        query.setParameter("amount", new Long(i));
        return query.getResultList();
	}
	
	@Override
	public int findCarsAmountRentedInSpecifiedTime(Date from, Date to){
		TypedQuery<CarEntity> query = entityManager.createQuery(
		          	"select car from CarEntity car "
		        + 	"join car.rentals rentals " 
		        +	"where "
		        + 	"(rentals.rentBegin >= :from and rentals.rentBegin <= :to)"
		        + 	" or "
		        + 	"(rentals.rentEnd >= :from and rentals.rentEnd <= :to)"
		        + 	" or "
		        + 	"(rentals.rentBegin <= :from and rentals.rentEnd >= :to)"
		        
		        , CarEntity.class
		        );
		        query.setParameter("from", from);
		        query.setParameter("to", to);
		return query.getResultList().size();
	}
}