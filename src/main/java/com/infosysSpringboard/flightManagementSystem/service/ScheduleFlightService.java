package com.infosysSpringboard.flightManagementSystem.service;

import java.time.LocalDate;
import java.util.List;

import com.infosysSpringboard.flightManagementSystem.entity.Airport;
import com.infosysSpringboard.flightManagementSystem.entity.Flight;
import com.infosysSpringboard.flightManagementSystem.entity.Schedule;
import com.infosysSpringboard.flightManagementSystem.entity.ScheduleFlight;

public interface ScheduleFlightService {
	
	public ScheduleFlight scheduleFlight(ScheduleFlight scheduleFlight);
	public List<ScheduleFlight> viewScheduledFlight();
	public Flight viewScheduledFlight(long  flightNumber) throws Exception;
	
	public void deleteScheduledFlight(int id);
	
	public List<ScheduleFlight> viewScheduledFlight( Airport source , Airport destination , LocalDate date   );
	
	public ScheduleFlight modifyScheduledFlight(Flight flight , Schedule schedule, int availableSeats);
	
	public void validateScheduledFlight(ScheduleFlight scheduledflight); 

}
