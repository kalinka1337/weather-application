package com.meawallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam Double lat, @RequestParam Double lon) {
        Double temperature = weatherService.getTemperature(lat, lon);
        WeatherResponse response = new WeatherResponse(temperature);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/test")
    public String test() {
        return "Test";
    }

}
