package com.infosysSpringboard.flightManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infosysSpringboard.flightManagementSystem.entity.ScheduleFlight;

public interface ScheduleFlightRepository  extends JpaRepository<ScheduleFlight,Integer>{
	 ScheduleFlight findByFlight_FlightNumber(long flightNumber);

}
