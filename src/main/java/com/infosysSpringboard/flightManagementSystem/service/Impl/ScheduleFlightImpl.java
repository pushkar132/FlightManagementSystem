package com.infosysSpringboard.flightManagementSystem.service.Impl;
import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosysSpringboard.flightManagementSystem.dao.FlightRepository;
import com.infosysSpringboard.flightManagementSystem.dao.ScheduleFlightRepository;
import com.infosysSpringboard.flightManagementSystem.dao.ScheduleRepository;
import com.infosysSpringboard.flightManagementSystem.entity.Airport;
import com.infosysSpringboard.flightManagementSystem.entity.Flight;
import com.infosysSpringboard.flightManagementSystem.entity.Schedule;
import com.infosysSpringboard.flightManagementSystem.entity.ScheduleFlight;
import com.infosysSpringboard.flightManagementSystem.service.ScheduleFlightService;

@Service
public class ScheduleFlightImpl implements ScheduleFlightService {
	private ScheduleFlightRepository scheduleFlightRepository ;
	@Autowired
	private FlightRepository flightrepository;
	@Autowired
	private ScheduleRepository schedulerepository;
	
	public ScheduleFlightImpl(ScheduleFlightRepository scheduleFlightRepository) {
		this.scheduleFlightRepository = scheduleFlightRepository;
	}
	
	@Override
	public ScheduleFlight scheduleFlight(ScheduleFlight scheduleFlight) {
		scheduleFlightRepository.save(scheduleFlight);
		return scheduleFlight;
	}

	@Override
	public List<ScheduleFlight> viewScheduledFlight() {
		System.out.println("Impl Get");
		List<ScheduleFlight> sf= scheduleFlightRepository.findAll();
		return sf;
	}

	@Override
	public Flight viewScheduledFlight(long flightNumber) throws Exception {
		ScheduleFlight scheduledflight = scheduleFlightRepository.findByFlight_FlightNumber(flightNumber);
		if(scheduledflight==null) {		
			throw new Exception("Flight with number " + flightNumber + " is not scheduled.") ;
		}
		return scheduledflight.getFlight();
	}

	@Override
	public void deleteScheduledFlight(int id) {
		
		Optional<ScheduleFlight> scheduledflight = scheduleFlightRepository.findById(id);
		
		if(scheduledflight.isPresent()) {

			scheduleFlightRepository.deleteById(id);
		}
		else {
			
			 throw new RuntimeException("ScheduleFlight with ID " + id + " not found");
		}
		
	}

	@Override
	public List<ScheduleFlight> viewScheduledFlight(Airport sourceARP, Airport destinationARP, LocalDate date) {
		
		List<ScheduleFlight> FilteredFlight = new ArrayList<>();
		List<ScheduleFlight >  allSchFlight = scheduleFlightRepository.findAll();
		for(ScheduleFlight flight :allSchFlight ) {
			if(flight.getSchedule().getSourceAirport().equals(sourceARP) && 
					flight.getSchedule().getDestinationAirport().equals(destinationARP) &&
						flight.getSchedule().getDepartureTime().toLocalDate().isEqual(date)) {
				
				FilteredFlight.add(flight);
				
			}
			
		}
		
		return FilteredFlight;
		
	}

	@Override
	public ScheduleFlight modifyScheduledFlight(Flight flight, Schedule schedule, int availableSeats) {
		ScheduleFlight sf  = scheduleFlightRepository.findByFlight_FlightNumber(flight.getFlightNumber());

		if(sf!=null) {
			sf.setFlight(flight);
			sf.setSchedule(schedule);	
			sf.setAvailablleSeat(availableSeats);
			sf = scheduleFlightRepository.save(sf);
		}
		else {
			System.out.println("sf is Null");
		}
		
		return  sf;
	}

	@Override
	public void validateScheduledFlight(ScheduleFlight scheduledflight) {
		
		Flight flight = scheduledflight.getFlight();
		Schedule schedule = scheduledflight.getSchedule();
//		
		Optional<Flight> existingFlight=flightrepository.findById(flight.getFlightNumber());
		 Optional<Schedule> optionalSchedule = schedulerepository.findById(schedule.getSchedule_id());
		if(existingFlight.isEmpty() || optionalSchedule.isEmpty()) {

			System.out.println("Flight or Schedule  is Not  valid");
		}
		else {
			System.out.println("Flight and schedule  is valid");
		}
		
		
	}
	
	

}
