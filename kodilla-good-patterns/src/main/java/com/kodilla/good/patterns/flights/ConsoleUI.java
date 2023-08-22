package com.kodilla.good.patterns.flights;

import java.util.Scanner;
import java.util.Set;

public class ConsoleUI {
    private FlightSearch flightSearch;

    public ConsoleUI(FlightSearch flightSearch) {
        this.flightSearch = flightSearch;
    }

    public void displayMenu() {
        System.out.println("Flight Search Engine Menu:");
        System.out.println("1. Search for flights from a selected city");
        System.out.println("2. Search for flights to a selected city");
        System.out.println("3. Search for transfer flights to a city");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        flightSearch.flightDatabase.initializeFlightsData();

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter departure city: ");
                    String departureCity = scanner.nextLine();
                    Set<Flight> flightsFromCity = flightSearch.searchFlightsFromCity(departureCity);
                    displayFlights(flightsFromCity);
                    break;
                case 2:
                    System.out.print("Enter arrival city: ");
                    String arrivalCity = scanner.nextLine();
                    Set<Flight> flightsToCity = flightSearch.searchFlightsToCity(arrivalCity);
                    displayFlights(flightsToCity);
                    break;
                case 3:
                    System.out.print("Enter destination city: ");
                    String destinationCity = scanner.nextLine();
                    Set<Flight> transferFlights = flightSearch.searchFlightsWithTransfer(destinationCity);
                    displayFlights(transferFlights);

                    break;
                case 4:
                    System.out.println("Exiting Flight Search Engine. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void displayFlights(Set<Flight> flights) {
        if (flights.isEmpty()) {
            System.out.println("No flights found.");
        } else {
            System.out.println("Flights:");
            for (Flight flight : flights) {
                System.out.println("Flight Number: " + flight.getFlightNumber());
                System.out.println("Departure Airport: " + flight.getDepartureAirport());
                System.out.println("Arrival Airport: " + flight.getArrivalAirport());
                if (flight.getTransferAirport() != null) { // Check for null transfer airport
                    System.out.println("Transfer Airport: " + flight.getTransferAirport());
                }
                System.out.println(); // Add an empty line between flights
            }
        }
    }
}
