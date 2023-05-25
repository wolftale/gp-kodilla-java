package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        Collection<Double> temperatureValues = temperatures.getTemperatures().values();
        double sum = 0;
        for (Double temperature : temperatureValues) {
            sum += temperature;
        }
        return sum / temperatureValues.size();
    }

    public double calculateMedianTemperature() {
        Collection<Double> temperatureValues = temperatures.getTemperatures().values();
        List<Double> sortedTemperatures = new ArrayList<>(temperatureValues);
        Collections.sort(sortedTemperatures);
        int size = sortedTemperatures.size();
        if (size % 2 == 0) {
            int midIndex = size / 2;
            double median = (sortedTemperatures.get(midIndex - 1) + sortedTemperatures.get(midIndex)) / 2;
            return median;
        } else {
            int midIndex = size / 2;
            return sortedTemperatures.get(midIndex);
        }
    }
}
