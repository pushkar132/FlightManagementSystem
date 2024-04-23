package com.infosysSpringboard.flightManagementSystem.service;

import java.util.List;

import com.infosysSpringboard.flightManagementSystem.entity.Airport;

public interface AirportService {
	
	public List<Airport> viewAirport();
	public Airport viewAirport(String airportCode);

}

/*

viewAirport():
List<Airport> :-
Returns the list of all
airports.
viewAirport(String): Airport :-
Returns the details of an airport identifiable by the
airport code.


*/