package com.kodilla.good.patterns.flights;

public class FlightSearchApp {
    public static void main(String[] args) {
        FlightDatabase database = new FlightDatabase();
        FlightSearch flightSearch = new FlightSearch(database);
        ConsoleUI consoleUI = new ConsoleUI(flightSearch);
        consoleUI.run();
    }
}
