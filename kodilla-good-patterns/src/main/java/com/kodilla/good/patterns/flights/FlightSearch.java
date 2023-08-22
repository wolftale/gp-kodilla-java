package com.kodilla.good.patterns.flights;

import java.util.Set;
import java.util.stream.Collectors;

public class FlightSearch {
    FlightDatabase flightDatabase;

    public FlightSearch(FlightDatabase flightDatabase) {
        this.flightDatabase = flightDatabase;
    }

    public Set<Flight> searchFlightsFromCity(String city) {
        return flightDatabase.getAllFlights().stream()
                .filter(flight ->
                        flight.getDepartureAirport().equals(city))
                .collect(Collectors.toSet());
    }

    public Set<Flight> searchFlightsToCity(String city) {
        return flightDatabase.getAllFlights().stream()
                .filter(flight -> flight.getArrivalAirport().equals(city))
                .collect(Collectors.toSet());
    }

    public Set<Flight> searchFlightsWithTransfer(String destinationCity) {
        return flightDatabase.getAllFlights().stream()
                .filter(flight ->
                        flight.getTransferAirport() != null &&
                                (destinationCity.equals(flight.getArrivalAirport()) ||
                                        destinationCity.equals(flight.getTransferAirport())))
                .collect(Collectors.toSet());
    }
}
