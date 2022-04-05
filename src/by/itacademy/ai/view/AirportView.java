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

	public void printFligthsOfChoosedDestination(String dest, Airport airport) {
		for (int i = 0; i < airport.getAirlines().size(); i++) {
			if (dest.equals(airport.getAirlines().get(i).getDestination())) {
				System.out.println(airport.getAirlines().get(i));
			}
		}
	}

	public void printStringList(List<String> lists) {
		for (String list : lists) {
			System.out.println(list);
		}
	}

	public void printFligthsOfChoosedDepartureDay(String day, Airport airport) {
		for (int i = 0; i < airport.getAirlines().size(); i++) {
			if (day.equals(airport.getAirlines().get(i).getDepartureDay())) {
				System.out.println(airport.getAirlines().get(i));
			}
		}
	}

	public void printFligthsOfChoosedDepartureTime(String day, String time, Airport airport) {
		if (time.length() != 5) {
			throw new RuntimeException("Время введено неверено.");
		}
		int hour = Integer.parseInt(time.substring(0, 2));
		int min = Integer.parseInt(time.substring(3, 5));
		boolean isFlight = false;
		for (int i = 0; i < airport.getAirlines().size(); i++) {
			if (day.equals(airport.getAirlines().get(i).getDepartureDay())) {
				int airHour = Integer.parseInt(airport.getAirlines().get(i).getDepartureTime().substring(0, 2));
				int airMin = Integer.parseInt(airport.getAirlines().get(i).getDepartureTime().substring(3, 5));
				if (airHour > hour) {
					System.out.println(airport.getAirlines().get(i));
					isFlight = true;
				} else if (airHour == hour && airMin >= min) {
					System.out.println(airport.getAirlines().get(i));
					isFlight = true;
				}
			}
		}
		if (!isFlight) {
			System.out.println("Таких рейсов нет.\n");
		}
	}

}
