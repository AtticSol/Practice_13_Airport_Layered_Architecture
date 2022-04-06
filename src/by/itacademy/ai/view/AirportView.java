package by.itacademy.ai.view;

import java.util.List;

import by.itacademy.ai.bean.Airline;
import by.itacademy.ai.bean.Airport;

public class AirportView {
	
	public void printList(Airport airport) {
		for (Airline airline : airport.getAirlines()) {
			System.out.println(airline.toString());
		}
	}

	public void printList(List<String> lists) {
		for (String list : lists) {
			System.out.println(list);
		}
	}
	
	public void printFligths(List<Airline> flights) {
		for (Airline flight : flights) {
			System.out.println(flight);
		}		
	}
}
