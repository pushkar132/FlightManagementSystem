package com.infosysSpringboard.flightManagementSystem.service;


import java.util.List;

import com.infosysSpringboard.flightManagementSystem.entity.Flight;


public interface FlightService {
	
	 public Flight addFlight(Flight flight);
	 public Flight  modifyFlight(Flight flight);
	 public Flight viewFlight(long flightNumber);
	 public List<Flight> viewFlight() ;
	 public void deleteFlight(long flightNumber);
	 public void validateFlight(Flight flight);
	 
	 

}


/*
addFlight(Flight): Flight :-
Adds a new flight which can be scheduled.

modifyFlight(Flight): Flight :-
Modify the details of a flight.

viewFlight(int): Flight :-
Shows the details of a flight specified by the flight number.


viewFlight(): List<Flight> :-
View the details of all flights.

deleteFlight(int):
void :- Removes a flight.

validateFlight(Flight
): void :- Validates
the attributes of a
flight.

*/