package com.capgemini.jstk.carrentaljpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarRentalJPAApplication 
{
	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "mysql");
		SpringApplication.run(CarRentalJPAApplication.class, args);
	}
}
