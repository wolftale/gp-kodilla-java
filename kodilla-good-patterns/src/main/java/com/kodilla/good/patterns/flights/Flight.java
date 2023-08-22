package com.kodilla.good.patterns.flights;

import java.util.Objects;

public class Flight {
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private String transferAirport;

    public Flight(String flightNumber, String departureAirport, String arrivalAirport, String transferAirport) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.transferAirport = transferAirport;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getTransferAirport() {
        return transferAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightNumber, flight.flightNumber) &&
                Objects.equals(departureAirport, flight.departureAirport) &&
                Objects.equals(arrivalAirport, flight.arrivalAirport) &&
                Objects.equals(transferAirport, flight.transferAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, departureAirport, arrivalAirport, transferAirport);
    }
}
