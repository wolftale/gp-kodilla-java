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
        addFlight(new Flight("LO 123", "Warszawa", "Kraków", null));
        addFlight(new Flight("LO 123", "Warszawa", "Gdańsk", null));
        addFlight(new Flight("LO 123", "Warszawa", "Wrocław", null));
        addFlight(new Flight("LO 123", "Warszawa", "Szczecin", null));
        addFlight(new Flight("LO 123", "Warszawa", "Katowice", null));
        addFlight(new Flight("LO 123", "Kraków", "Warszawa", null));
        addFlight(new Flight("LO 123", "Kraków", "Gdańsk", "Wrocław"));
        addFlight(new Flight("LO 123", "Kraków", "Wrocław", null));
        addFlight(new Flight("LO 123", "Kraków", "Szczecin", "Warszawa"));
        addFlight(new Flight("LO 123", "Kraków", "Gdańsk", "Katowice"));
        addFlight(new Flight("LO 123", "Gdańsk", "Kraków", null));
        addFlight(new Flight("LO 123", "Gdańsk", "Warszawa", null));
        addFlight(new Flight("LO 123", "Gdańsk", "Katowice", null));
        addFlight(new Flight("LO 123", "Gdańsk", "Katowice", "Wrocław"));
        addFlight(new Flight("LO 123", "Gdańsk", "Katowice", "Kraków"));
        addFlight(new Flight("LO 123", "Katowice", "Warszawa", null));
        addFlight(new Flight("LO 123", "Katowice", "Gdańsk", null));
        addFlight(new Flight("LO 123", "Katowice", "Szczecin", "Warszawa"));
        addFlight(new Flight("LO 123", "Katowice", "Szczecin", "Wrocłąw"));
        addFlight(new Flight("LO 123", "Katowice", "Gdańsk", "Warszawa"));
        addFlight(new Flight("LO 123", "Szczecin", "Kraków", "Warszawa"));
        addFlight(new Flight("LO 123", "Szczecin", "Katowice", "Wrocław"));
        addFlight(new Flight("LO 123", "Szczecin", "Wrocław", null));
        addFlight(new Flight("LO 123", "Wrocław", "Gdańsk", null));
        addFlight(new Flight("LO 123", "Wrocław", "Gdańsk", "Warszawa"));
        addFlight(new Flight("LO 123", "Wrocław", "Katowice", null));
        addFlight(new Flight("LO 123", "Wrocław", "Szczecin", "Warszawa"));
        addFlight(new Flight("LO 123", "Wrocław", "Kraków", null));
    }
}
