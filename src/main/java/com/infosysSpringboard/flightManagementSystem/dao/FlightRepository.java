package com.infosysSpringboard.flightManagementSystem.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.infosysSpringboard.flightManagementSystem.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight,Long> {

}
