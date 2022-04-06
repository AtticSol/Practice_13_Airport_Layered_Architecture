package by.itacademy.ai.main;

import java.util.List;
import java.util.Scanner;

import by.itacademy.ai.bean.Airline;
import by.itacademy.ai.bean.Airport;
import by.itacademy.ai.logic.FlightLists;
import by.itacademy.ai.logic.AirportLogic;
import by.itacademy.ai.view.AirportView;

public class FlightSchedule {

	public static void main(String[] args) {
		
		Airport airport = new Airport("Minsk-MSQ");
		
		FlightLists flightsLists = new FlightLists();
		AirportView view = new AirportView();
		AirportLogic logic = new AirportLogic();

		logic.addAirline(airport, new Airline("Dubai", 2727, "Boeing 7370", "05:20", "Wednesday"));
		logic.addAirline(airport, new Airline("Paris", 1515, "Airbus A321", "12:55", "Friday"));
		logic.addAirline(airport, new Airline("Tokyo", 9750, "Boeing 7370", "08:30", "Friday"));
		logic.addAirline(airport, new Airline("Seoul", 1484, "Airbus A321", "10:15", "Monday"));
		logic.addAirline(airport, new Airline("Seoul", 6191, "Boeing 7370", "06:20", "Friday"));
		logic.addAirline(airport, new Airline("Dubai", 2863, "Airbus A321", "22:15", "Saturday"));
		logic.addAirline(airport, new Airline("Paris", 2185, "Airbus A321", "06:25", "Monday"));

		menu(airport, flightsLists, view);
	}

	public static void menu(Airport airport, FlightLists flightsLists, AirportView view) {

		Scanner scInt = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);

		while (true) {
			System.out.print("Выберите пункт меню: \n" + "0. выйти\n" + "1. вывод списка всех рейсов\n"
					+ "2. вывод списка рейсов для заданного пункта назначения\n"
					+ "3. вывод списка рейсов для заданного дня недели\n"
					+ "4. вывод списка рейсов для заданного дня недели, время вылета для которых больше заданного\n>> ");
			int choice = scInt.nextInt();
			if (choice == 0) {
				break;
			}
			if (choice < 1 || choice > 4) {
				System.out.println("Выбран несуществующий пункт меню. Повторите выбор: ");
				continue;
			}
			System.out.println("----------------------------------------------");
			switch (choice) {
			case 1:
				view.printList(airport);
				System.out.println("----------------------------------------------");
				break;
			case 2:
				System.out.println("Выберите пункт назначения: ");
				List<String> destinations = flightsLists.listOfDestinations(airport);
				view.printList(destinations);
				System.out.print(">> ");
				String dest = scString.nextLine();
				System.out.println("Рейсы в " + dest + ":");
				List<Airline> choosedDestination = flightsLists.fligthsOfChoosedDestination(dest, airport);
				view.printFligths(choosedDestination); 
				System.out.println("----------------------------------------------");

				while (true) {
					System.out.print("Выберите пункт меню: \n" + "0. назад\n"
							+ "1. вывод списка рейсов для другого пункта назначения\n>> ");
					int choice2 = scInt.nextInt();
					if (choice2 == 0) {
						System.out.println("----------------------------------------------");
						break;
					}
					if (choice2 > 1) {
						System.out.println("Выбран несуществующий пункт меню. Повторите выбор: ");
						continue;
					}
					System.out.println("----------------------------------------------");
					switch (choice2) {
					case 1:
						System.out.print("Выберите пункт назначения: >> ");
						dest = scString.nextLine();
						System.out.println("Рейсы в " + dest + ":");
						choosedDestination = flightsLists.fligthsOfChoosedDestination(dest, airport);
						view.printFligths(choosedDestination); 
						System.out.println("----------------------------------------------");
					}
					continue;
				}
				break;
			case 3:
				System.out.println("Есть запланированные рейсы в следующие дни недели: ");
				List<String> days = flightsLists.listOfDepartureDays(airport);
				view.printList(days);
				System.out.print("Выберите день недели: >> ");
				String day = scString.nextLine();
				System.out.println("Доступные рейсы в " + day + ":");
				List<Airline> choosedDay = flightsLists.fligthsOfChoosedDepartureDay(day, airport);
				view.printFligths(choosedDay); 
				System.out.println("----------------------------------------------");

				while (true) {
					System.out.print("Выберите пункт меню: \n" + "0. назад\n"
							+ "1. вывод списка рейсов для другого дня недели\n>> ");
					int choice2 = scInt.nextInt();
					if (choice2 == 0) {
						System.out.println("----------------------------------------------");
						break;
					}
					if (choice2 > 1) {
						System.out.println("Выбран несуществующий пункт меню. Повторите выбор: ");
						continue;
					}
					System.out.println("----------------------------------------------");
					switch (choice2) {
					case 1:
						System.out.print("Выберите день недели: >> ");
						day = scString.nextLine();
						System.out.println("Доступные рейсы в " + day + ":");
						choosedDay = flightsLists.fligthsOfChoosedDepartureDay(day, airport);
						view.printFligths(choosedDay);
						System.out.println("----------------------------------------------");
					}
					continue;
				}
				break;
			case 4:
				System.out.println("Есть запланированные рейсы в следующие дни недели: ");
				view.printList(flightsLists.listOfDepartureDays(airport));
				System.out.print("Выберите день недели: >> ");
				day = scString.nextLine();
				System.out.print("Введите время отправления (не ранее, чем) в формате 00:00: >> ");
				String time = scString.nextLine();
				System.out.println("В " + day + " позже " + time + " есть следующие рейсы:");
				List<Airline> choosedDayAndTime = flightsLists.fligthsOfChoosedDepartureTime(day, time, airport); 
				view.printFligths(choosedDayAndTime);
				System.out.println("----------------------------------------------");

				while (true) {
					System.out.print("Выберите пункт меню: \n" + "0. назад\n"
							+ "1. вывод списка рейсов для другого дня недели и времени\n>> ");
					int choice2 = scInt.nextInt();
					if (choice2 == 0) {
						System.out.println("----------------------------------------------");
						break;
					}
					if (choice2 > 1) {
						System.out.println("Выбран несуществующий пункт меню. Повторите выбор: ");
						continue;
					}
					System.out.println("----------------------------------------------");
					switch (choice2) {
					case 1:
						System.out.print("Выберите день недели: >> ");
						day = scString.nextLine();
						System.out.print("Введите время отправления (не ранее, чем) в формате 00:00: >> ");
						time = scString.nextLine();
						System.out.println("В " + day + " позже " + time + " есть следующие рейсы:");
						choosedDayAndTime = flightsLists.fligthsOfChoosedDepartureTime(day, time, airport); 
						view.printFligths(choosedDayAndTime);
						System.out.println("----------------------------------------------");
					}
					continue;
				}
				break;
			}
		}
		scInt.close();
		scString.close();
	}

}
