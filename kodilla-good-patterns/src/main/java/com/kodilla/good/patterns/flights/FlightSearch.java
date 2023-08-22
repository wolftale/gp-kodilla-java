package com.kodilla.good.patterns.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightSearch {
    FlightDatabase flightDatabase;

    public FlightSearch(FlightDatabase flightDatabase) {
        this.flightDatabase = flightDatabase;
    }

    public Set<Flight> searchFlightsFromCity(String city) {
        return flightDatabase.getAllFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(city))
                .collect(Collectors.toSet());
    }

    public Set<Flight> searchFlightsToCity(String city) {
        return flightDatabase.getAllFlights().stream()
                .filter(flight -> flight.getArrivalAirport().equals(city))
                .collect(Collectors.toSet());
    }

    public Set<Flight> searchFlightsWithTransfer(String destinationCity) {
        Set<Flight> transferFlights = new HashSet<>();

        for (Flight flight1 : flightDatabase.getAllFlights()) {
            if (flight1.getArrivalAirport().equals(destinationCity)) {
                for (Flight flight2 : flightDatabase.getAllFlights()) {
                    if (flight1.getDepartureAirport().equals(flight2.getArrivalAirport())) {
                        Flight transferFlight = new Flight(
                                flight1.getFlightNumber() + " -> " + flight2.getFlightNumber(),
                                flight1.getDepartureAirport(),
                                flight2.getArrivalAirport()
                        );
                        transferFlights.add(transferFlight);
                    }
                }
            }
        }

        return transferFlights;
    }
}
