package com.infosysSpringboard.flightManagementSystem.entity;
import java.time.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int Schedule_id;

	  
	
	@OneToOne
	private Airport sourceAirport;
	@OneToOne
	private Airport destinationAirport;
	
	private LocalDateTime arrivalTime;
	
	private LocalDateTime departureTime;

	public Schedule(int Schedule_id, Airport sourceAirport, Airport destinationAirport, LocalDateTime arrivalTime,
			LocalDateTime departureTime) {
		super();
	
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	public Schedule() {
		
		
	}

	public int getSchedule_id() {
		return Schedule_id;
	}
	
	public void setSchedule_id(int Schedule_id) {
		this.Schedule_id = Schedule_id;
	}
	
	public Airport getSourceAirport() {
		return sourceAirport;
	}
	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	@Override
	public String toString() {
		return "Schedule [id=" + Schedule_id + ", sourceAirport=" + sourceAirport + ", destinationAirport=" + destinationAirport
				+ ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
	}
	
	

	
}


/*
sourceAirport:
Airport
destinationAirpor
t: Airport
arrivalTime:
DateTime
departureTime:
DateTime
*/

/*
 
ScheduledFlightDaoImpl:
Attributes:
scheduledFlightList: List<ScheduledFlight>
Methods:

scheduleFlight(ScheduledFlight): ScheduledFlight :-
Schedules a flight alongwith its timings, locations and capacity
viewScheduledFlights(Airport, Airport, LocalDate):
List<Scheduled Flight> :-
Returns a list of flights between two airports on a specified date.
viewScheduledFlights(BigInteger):Flight :-
Returns a list of a scheduled flight identifiable by flight number.
viewScheduledFlight():
List<ScheduledFlight> :- Shows all the
details and status of all flights.
modifyScheduledFlight(Flight,Schedule,int): ScheduledFlight
:- Modifies the details of a scheduled flight.
deleteScheduledFlight(BigInteger): void
:- Removes a flight from the available
flights.

*/


/*

ScheduleFlightServicesImpl:
Attributes: - Methods:

scheduleFlight(ScheduledFlight): ScheduledFlight :-
Schedules a flight alongwith its timings, locations and capacity

viewScheduledFlights(Airport, Airport, LocalDate):
List<Scheduled Flight> :-
Returns a list of flights between two airports on a specified date.

viewScheduledFlights(BigInteger):Flight :-
Returns a list of a scheduled flight identifiable by flight number.
viewScheduledFlight():


List<ScheduledFlight> :- Shows all the
details and status of all flights.

modifyScheduledFlight(Flight,Schedule, Integer):
ScheduledFlight
:- Modifies the details of a scheduled flight.

deleteScheduledFlight(BigInteger): void
:- Removes a flight from the available
flights.

validateScheduledFlight(ScheduledFlight):
void :- Validates the attributes of a
scheduled Flight.

*/

/*
ScheduledFlight: This class stores a flight that is scheduled along with its schedule and the
vacancy.
Attributes:
flight: Flight
availableSeats
: Integer
schedule:
Schedule

*/