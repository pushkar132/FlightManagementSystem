package com.infosysSpringboard.flightManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosysSpringboard.flightManagementSystem.entity.Airport;



public interface AirportRepository extends JpaRepository<Airport,String> {

	
	
}
