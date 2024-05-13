package com.infosysSpringboard.flightManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosysSpringboard.flightManagementSystem.entity.*;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {

}
