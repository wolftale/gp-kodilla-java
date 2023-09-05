package com.kodilla.good.patterns.flights;

import java.util.HashSet;
import java.util.Set;

public class FlightDatabase {
    private Set<Flight> flights = new HashSet<>();

    public FlightDatabase() {
        initializeFlightsData();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Set<Flight> getAllFlights() {
        return flights;
    }

    public void initializeFlightsData() {
        // flights without transfer
        addFlight(new Flight("LO 123", "Warszawa", "Kraków"));
        addFlight(new Flight("LO 124", "Warszawa", "Gdańsk"));
        addFlight(new Flight("LO 125", "Warszawa", "Wrocław"));
        addFlight(new Flight("LO 126", "Warszawa", "Szczecin"));
        addFlight(new Flight("LO 127", "Warszawa", "Katowice"));
        addFlight(new Flight("LO 128", "Kraków", "Warszawa"));
        addFlight(new Flight("LO 129", "Kraków", "Wrocław"));
        addFlight(new Flight("LO 130", "Kraków", "Szczecin"));
        addFlight(new Flight("LO 131", "Gdańsk", "Kraków"));
        addFlight(new Flight("LO 132", "Gdańsk", "Warszawa"));
        addFlight(new Flight("LO 133", "Gdańsk", "Katowice"));
        addFlight(new Flight("LO 134", "Gdańsk", "Szczecin"));
        addFlight(new Flight("LO 135", "Gdańsk", "Wrocław"));
        addFlight(new Flight("LO 136", "Katowice", "Warszawa"));
        addFlight(new Flight("LO 137", "Katowice", "Gdańsk"));
        addFlight(new Flight("LO 138", "Szczecin", "Wrocław"));
        addFlight(new Flight("LO 139", "Wrocław", "Gdańsk"));
        addFlight(new Flight("LO 140", "Wrocław", "Warszawa"));
        addFlight(new Flight("LO 141", "Wrocław", "Katowice"));
        addFlight(new Flight("LO 142", "Wrocław", "Szczecin"));
        addFlight(new Flight("LO 143", "Wrocław", "Kraków"));
    }
}
