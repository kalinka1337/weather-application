package com.meawallet;


public class WeatherResponse {

    private Double temperature;

    public WeatherResponse(Double temperature) {
        this.temperature = temperature;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

}

