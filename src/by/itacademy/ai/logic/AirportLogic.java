package by.itacademy.ai.logic;

import by.itacademy.ai.bean.Airline;
import by.itacademy.ai.bean.Airport;

public class AirportLogic {
	
	public void addAirline(Airport airport, Airline airline) {
		airport.getAirlines().add(airline);
	}

}
