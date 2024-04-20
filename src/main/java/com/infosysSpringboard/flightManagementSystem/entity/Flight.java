package com.infosysSpringboard.flightManagementSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Flights")
public class Flight {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long flightNumber;
	
	@Column(name="flight_model")
	private String flightModel;
	
	@Column(name="carrier_name")
	private String carrierName;
	
	@Column(name="seat_capacity")
	private int seatCapacity;
	
	//member created +constructor+getterSetter

	
	public Flight( String flightModel, String carrierName, int seatCapacity) {
		
		this.flightModel = flightModel;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
	}
	public Flight() {
		
	}
	


	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + 
				", flightModel=" + flightModel + 
				", carrierName=" + carrierName+
				", seatCapacity=" + seatCapacity + 
				"]";
	}
	
}



//flightNumber:
//int
//flightModel:
//String
//carrierName:
//String
//seatCapacity:
//Integer
