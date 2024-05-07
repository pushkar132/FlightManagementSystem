package com.infosysSpringboard.flightManagementSystem.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.infosysSpringboard.flightManagementSystem.entity.Flight;
import com.infosysSpringboard.flightManagementSystem.service.FlightService;
import com.infosysSpringboard.flightManagementSystem.service.UserService;

@RestController
public class FlightController {
	
	  private FlightService flightService;

	    public FlightController(FlightService flightService) {
	        this.flightService = flightService;
	    }
	    
	    
	    @GetMapping("/flights")
	    public List<Flight> viewFlights(){
	    	return flightService.viewFlight();
	    }
	    
	    @GetMapping("/flights/{flightNumber}")
	    public Flight viewFlight(@PathVariable long flightNumber){
	    	return flightService.viewFlight(flightNumber);
	    }
	    
	    
	    @PostMapping("/flights")
	    public Flight addFlight(@RequestBody Flight flight) {
	    	flightService.addFlight(flight);
	    	return flight;
	    }
	    
	    @PutMapping("/flights")
	    public Flight modifyFlight(@RequestBody Flight flight) {
	    	flightService.addFlight(flight);
	    	return flight;
	    }
	    
	    @DeleteMapping("/flights/{flightNumber}")
	    public Flight deleteFlight(@PathVariable long flightNumber) {
	    	if(flightService.viewFlight(flightNumber) == null) {
	    		throw new RuntimeException("Flight with FlightNumber : "+ flightNumber+" , Not found");
	    	}
	    	
	    	Flight f = flightService.viewFlight(flightNumber);
	    	flightService.deleteFlight(flightNumber);
	    	
	    	return f;
	    	
	    	
	    }
	    

	
	
}

/*
public Flight addFlight(Flight flight);
public Flight  modifyFlight(Flight flight);
public Flight viewFlight(int flightNumber);
public List<Flight> viewFlight() ;
public void deleteFlight(int flightNumber);
public void validateFlight(Flight flight);
*/