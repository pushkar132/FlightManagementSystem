package com.infosysSpringboard.flightManagementSystem.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.infosysSpringboard.flightManagementSystem.dao.AirportRepository;
import com.infosysSpringboard.flightManagementSystem.entity.Airport;
import com.infosysSpringboard.flightManagementSystem.service.AirportService;


@Service
public class AirportServiceImpl implements AirportService {
	
	
	private AirportRepository airportRepository;
	
	public AirportServiceImpl( AirportRepository airportRepository) {
		this.airportRepository =airportRepository;
	}

	
	@Override
	public List<Airport> viewAirport() {
		
		return airportRepository.findAll();
	}

	@Override
	public Airport viewAirport(String airportCode) {
		Optional<Airport> airPortById = airportRepository.findById(airportCode);
		Airport airport = null;
		if(airPortById.isPresent()) {
			airport = airPortById.get();
		}
		else {
			throw new RuntimeException("Airport with AirportCode : "+airportCode + "  not found .");
		}
		
		return airport;
	}

}
