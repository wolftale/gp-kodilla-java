package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    private Map<String, Boolean> flightMap;

    public FlightSearch() {
        flightMap = new HashMap<>();
        flightMap.put("WAW", true);
        flightMap.put("KRK", true);
        flightMap.put("GDN", false);
        flightMap.put("KTW", true);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {
        if (!flightMap.containsKey(flight.getArrivalAirport()) ||
                !flightMap.containsKey(flight.getDepartureAirport())) {
            throw new RouteNotFoundException("Flight route not found.");
        }
    }
}

