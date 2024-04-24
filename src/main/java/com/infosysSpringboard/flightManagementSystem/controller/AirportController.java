package com.infosysSpringboard.flightManagementSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infosysSpringboard.flightManagementSystem.entity.Airport;
import com.infosysSpringboard.flightManagementSystem.service.AirportService;

@RestController
public class AirportController {

	private AirportService airportService;

	public AirportController(AirportService airportService) {
		super();
		this.airportService = airportService;
	}
	
	@GetMapping("/airports")
	public List<Airport> viewAirport(){
			return airportService.viewAirport();
	}
	
	@GetMapping("/airports/{airportCode}")
	public Airport  viewAirport(@PathVariable String airportCode) {
		return airportService.viewAirport(airportCode);
	}
	
}
