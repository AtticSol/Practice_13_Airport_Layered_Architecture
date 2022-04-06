package by.itacademy.ai.logic;

import java.util.ArrayList;
import java.util.List;

import by.itacademy.ai.bean.Airline;
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
					if (!airport.getAirlines().get(j).getDestination()
							.equals(airport.getAirlines().get(i).getDestination())) {
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

	public List<Airline> fligthsOfChoosedDestination(String dest, Airport airport) {
		List<Airline> choosedDestination = new ArrayList<>();
		for (int i = 0; i < airport.getAirlines().size(); i++) {
			if (dest.equals(airport.getAirlines().get(i).getDestination())) {
				choosedDestination.add(airport.getAirlines().get(i));
			}
		}
		return choosedDestination;
	}

	public List<Airline> fligthsOfChoosedDepartureDay(String day, Airport airport) {
		List<Airline> choosedDay = new ArrayList<>();
		for (int i = 0; i < airport.getAirlines().size(); i++) {
			if (day.equals(airport.getAirlines().get(i).getDepartureDay())) {
				choosedDay.add(airport.getAirlines().get(i));
			}
		}
		return choosedDay;
	}

	public List<Airline> fligthsOfChoosedDepartureTime(String day, String time, Airport airport) {
		if (time.length() != 5) {
			throw new RuntimeException("Время введено неверено.");
		}
		
		List<Airline> choosedDayAndTime = new ArrayList<>();
		List<Airline> choosedDay = fligthsOfChoosedDepartureDay(day, airport);
		int hour = Integer.parseInt(time.substring(0, 2));
		int min = Integer.parseInt(time.substring(3, 5));
		boolean isFlight = false;

		for (int i = 0; i < choosedDay.size(); i++) {
			int airHour = Integer.parseInt(choosedDay.get(i).getDepartureTime().substring(0, 2));
			int airMin = Integer.parseInt(choosedDay.get(i).getDepartureTime().substring(3, 5));
			if (airHour > hour) {
				choosedDayAndTime.add(choosedDay.get(i));
				isFlight = true;
			} else if (airHour == hour && airMin >= min) {
				choosedDayAndTime.add(choosedDay.get(i));
				isFlight = true;
			}
		}
		
		if (!isFlight) {
			System.out.println("Таких рейсов нет.\n");
		}
		return choosedDayAndTime;
	}
}
