package com.capgemini.jstk.car_rental_jpa;

import org.springframework.boot.SpringApplication;

public class CarRentalJPAApplication 
{
	public static void main(String[] args) {
		// Uncomment line below to use mysql database (default database name = jstk, user = jstk, pass = jstk)
		// you can change this in application-mysql.properties
		System.setProperty("spring.profiles.active", "mysql");

		SpringApplication.run(CarRentalJPAApplication.class, args);
	}
}
