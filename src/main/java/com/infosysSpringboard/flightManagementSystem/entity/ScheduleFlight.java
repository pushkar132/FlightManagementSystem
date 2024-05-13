package com.infosysSpringboard.flightManagementSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name="schedule_flight")
public class ScheduleFlight {
	@Id
	@Column(name="Schedule_flight_id")
	private int id;
	
	@OneToOne
	private Flight flight;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "schedule_schedule_id", referencedColumnName = "schedule_id")
	private Schedule schedule;
	
	@Column(name="available_seats")
	private int availablleSeat;
	
	
	

	public ScheduleFlight(Flight flight, Schedule schedule, int availablleSeat) {
		if(availablleSeat<=flight.getSeatCapacity() ) {
		this.flight = flight;
		this.schedule = schedule;
		this.availablleSeat = availablleSeat;
		}
		else {
			throw new  RuntimeException("Available Seats can't be greater than flight seating capacity");
		}
	}
	
	public ScheduleFlight() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAvailablleSeat() {
		return availablleSeat;
	}

	public void setAvailablleSeat(int availablleSeat) {
		this.availablleSeat = availablleSeat;
	}
	@Override
	public String toString() {
	    return "ScheduleFlight{" +
	            "schedule_flight_id=" + id +
	            ", available_seats=" + availablleSeat +
	            ", flight_flight_number='" + flight + '\'' +
	            ", schedule_schedule_id=" + schedule +
	            '}';
	}
	
	

}
	