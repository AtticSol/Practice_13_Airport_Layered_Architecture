package by.itacademy.ai.list;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import by.itacademy.ai.bean.Airline;
import by.itacademy.ai.bean.Airport;
import by.itacademy.ai.logic.FlightLists;

public class FlightListsTest {
	@Test
	public void listOfDestinationsTest001() {
		Airport airport = new Airport("test 1");		
		airport.getAirlines().add(new Airline("London", 2, "Boeing", "00:20", "Wednesday"));
		FlightLists flightsLists = new FlightLists();
		
		List<String> destinationsActual = new ArrayList<>();
		List<String> destinationsExpected = new ArrayList<>();
		destinationsExpected.add("London");
		
		destinationsActual = flightsLists.listOfDestinations(airport);
		Assert.assertEquals(destinationsExpected, destinationsActual);
	}
	
	@Test
	public void listOfDepartureDaysTest001() {
		Airport airport = new Airport("test 2");
		airport.getAirlines().add(new Airline("London", 2, "Boeing", "00:20", "Wednesday"));
		FlightLists flightsLists = new FlightLists();
		
		List<String> daysActual = new ArrayList<>();
		List<String> daysExpected = new ArrayList<>();
		daysExpected.add("Wednesday");
		
		daysActual = flightsLists.listOfDepartureDays(airport);
		Assert.assertEquals(daysExpected, daysActual);

		
	}
	
}
