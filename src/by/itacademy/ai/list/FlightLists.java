package by.itacademy.ai.list;

import java.util.ArrayList;
import java.util.List;

import by.itacademy.ai.bean.Airport;

public class FlightLists {

	public List<String> listOfDestinations(Airport airport) {
		List<String> destinations = new ArrayList<>();
		boolean isNew = false;
		
		for (int i = 0; i < airport.getAirlines().size(); i++) {
			if (i == 0) {
				destinations.add(airport.getAirlines().get(i).getDestination());
			} else {
				for (int j = 0; j < i; j++) {
					if (!airport.getAirlines().get(j).getDestination().equals(airport.getAirlines().get(i).getDestination())) {
						isNew = true;
					} else {
						isNew = false;
						break;
					}
				}
				if (isNew) {
					destinations.add(airport.getAirlines().get(i).getDestination());
				}
			}
		}
		return destinations;
	}



	public List<String> listOfDepartureDays(Airport airport) {
		String[] weekDays = new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
				"Sunday" };
		List<String> departureDays = new ArrayList<>();
		boolean isNew = false;
		for (int i = 0; i < weekDays.length; i++) {
			for (int j = 0; j < airport.getAirlines().size(); j++) {
				if (airport.getAirlines().get(j).getDepartureDay().equals(weekDays[i])) {
					isNew = true;
				} else {
					isNew = false;
				}
				if (isNew) {
					departureDays.add(airport.getAirlines().get(j).getDepartureDay());
					break;
				}
			}
		}
		return departureDays;
	}
}
