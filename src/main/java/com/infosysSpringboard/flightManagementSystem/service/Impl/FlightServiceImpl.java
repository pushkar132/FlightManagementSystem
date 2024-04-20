package com.infosysSpringboard.flightManagementSystem.service.Impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosysSpringboard.flightManagementSystem.dao.FlightRepository;
import com.infosysSpringboard.flightManagementSystem.entity.Flight;
import com.infosysSpringboard.flightManagementSystem.service.FlightService;


@Service
public class FlightServiceImpl implements FlightService{
	
	
	 private FlightRepository flightRepository ;
	 
	 @Autowired
	 public FlightServiceImpl(FlightRepository flightrepository) {
		 this.flightRepository = flightrepository;
	 }
	 
	 	
	 
	 
	@Override
	public Flight addFlight(Flight flight) {
		flightRepository.save(flight);
		return flight;
	}

	@Override
	public Flight modifyFlight(Flight flight) {
		flightRepository.save(flight);
		return flight;
	}

	@Override
	public Flight viewFlight(long flightNumber) {
		Optional<Flight> flightById=flightRepository.findById(flightNumber);
		
		Flight flight=null;
		if(flightById.isPresent()) {
			flight = flightById.get();
		}
		else {
			throw new RuntimeException("Flight with flight Number : "+flightNumber+" was not found.");
		}
		
		return flight;
				
	}

	@Override
	public List<Flight> viewFlight() {
		List<Flight> listOfFlights =flightRepository.findAll();
		return listOfFlights;
	}

	@Override
	public void deleteFlight(long flightNumber) {
		
		flightRepository.deleteById(flightNumber);
		
	}

	@Override
	public void validateFlight(Flight flight) {
		// Don't Know what to do
	}

}
