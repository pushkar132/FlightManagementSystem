package com.infosysSpringboard.flightManagementSystem.entity.Miscellaneous;

import com.infosysSpringboard.flightManagementSystem.entity.Flight;
import com.infosysSpringboard.flightManagementSystem.entity.Schedule;

public class ModifyScheduledFlightRequest {
	private Flight flight;
    private Schedule schedule;
    private int availableSeats;
    
	public ModifyScheduledFlightRequest(Flight flight, Schedule schedule, int availableSeats) {
		super();
		this.flight = flight;
		this.schedule = schedule;
		this.availableSeats = availableSeats;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	
    
    

}
