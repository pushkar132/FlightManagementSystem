package com.infosysSpringboard.flightManagementSystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infosysSpringboard.flightManagementSystem.entity.Airport;
import com.infosysSpringboard.flightManagementSystem.entity.Flight;
import com.infosysSpringboard.flightManagementSystem.entity.Schedule;
import com.infosysSpringboard.flightManagementSystem.entity.ScheduleFlight;
import com.infosysSpringboard.flightManagementSystem.entity.Miscellaneous.ModifyScheduledFlightRequest;
import com.infosysSpringboard.flightManagementSystem.service.ScheduleFlightService;

@RestController
public class ScheduleFlightController {

	private ScheduleFlightService scheduleFlightService;
	
	public ScheduleFlightController(ScheduleFlightService scheduleFlightService) {
		this.scheduleFlightService =scheduleFlightService;
	}
	
	
	@PostMapping("/scheduleFlight")
	public ScheduleFlight scheduleFlight(@RequestBody ScheduleFlight scheduleFlight) {
		scheduleFlightService.scheduleFlight(scheduleFlight);
		return scheduleFlight;
	}
	
//	Post arrivalTime and post time syntax
//	"arrivalTime": "2024-04-30T12:00:00",
//    "departureTime": "2024-04-30T13:00:00",
	
	@GetMapping("/scheduleFlight")
	public List<ScheduleFlight> viewScheduledFlight(){
		List<ScheduleFlight> s = scheduleFlightService.viewScheduledFlight();
		System.out.println(s);
		return  s;
	}
	
	@GetMapping("/scheduleFlight/{flightNumber}")
	public Flight scheduledFlight(@PathVariable long flightNumber) throws Exception {
		return scheduleFlightService.viewScheduledFlight(flightNumber);
	}
	
	@DeleteMapping("/scheduleFlight/{id}")
	public void deleteScheduledFlight(@PathVariable int id) {
		scheduleFlightService.deleteScheduledFlight(id);
	}
	
	

	
	
	
	//http://localhost:8080/searchScheduledFlight?sourceAirport=ATQ&destinationAirport=AMD&DepartDate=2024-04-28
	// taking airport id and time  in parameters
	@GetMapping("/searchScheduledFlight")
	 public ResponseEntity<List<ScheduleFlight>> viewScheduledFlights(@RequestParam("sourceAirport") Airport sourceAirport,
            @RequestParam("destinationAirport") Airport destinationAirport,
            @RequestParam("DepartDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate DepartDate) {
		List<ScheduleFlight> flights = scheduleFlightService.viewScheduledFlight(sourceAirport, destinationAirport, DepartDate);

        return ResponseEntity.ok(flights);
	}
	
	
	@PutMapping("/scheduleFlight")
//	public ScheduleFlight  modifyScheduledFlight(@RequestParam("flight") Flight flight , @RequestParam("schedule") Schedule schedule , @RequestParam("availableSeats") int availableSeats  ) {
	public ScheduleFlight  modifyScheduledFlight(@RequestBody ModifyScheduledFlightRequest  modifyRequest) {
		
		Flight flight = modifyRequest.getFlight();
		
		Schedule schedule = modifyRequest.getSchedule();
		int availableSeats = modifyRequest.getAvailableSeats();
		
		ScheduleFlight changed = scheduleFlightService.modifyScheduledFlight(flight, schedule, availableSeats);
		
		return changed;
		
	}
	
	
	@GetMapping("/test")
	public void testFlight(@RequestBody  ScheduleFlight  toCheckschedul) {
		
		scheduleFlightService.validateScheduledFlight(toCheckschedul);
		
	}
	
	
	
	
}
