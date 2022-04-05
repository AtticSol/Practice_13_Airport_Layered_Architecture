package by.itacademy.ai.bean;

import java.util.ArrayList;
import java.util.List;

public class Airport {
	private String airportName;
	private List<Airline> airlines = new ArrayList<>();

	public Airport(String airportName) {
		this.airportName = airportName;
	}

	public List<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

}
