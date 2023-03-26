package com.meawallet;

public class WeatherResponse {

    private final Double temperature;

    public WeatherResponse(Double temperature) {
        this.temperature = temperature;
    }

    public Double getTemperature() {
        return temperature;
    }
}
