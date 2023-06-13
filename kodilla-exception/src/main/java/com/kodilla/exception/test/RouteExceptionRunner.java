package com.kodilla.exception.test;

public class RouteExceptionRunner {

    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();
        Flight flight = new Flight("WAW", "POZ");

        try {
            flightSearch.findFlight(flight);
            System.out.println("Flight route found.");
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
