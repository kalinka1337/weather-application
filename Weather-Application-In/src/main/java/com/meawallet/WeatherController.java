package com.meawallet;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

//    @GetMapping("/weather")
//    public ResponseEntity<WeatherResponse> getWeather(@RequestParam Double lat, @RequestParam Double lon) {
//        Double temperature = weatherService.getTemperature(lat, lon);
//        WeatherResponse response = new WeatherResponse(temperature);
//        return ResponseEntity.ok(response);
//    }
/*@GetMapping("/weather")
public ResponseEntity<Map<String, Double>> getTemperature(@RequestParam Double lat, @RequestParam Double lon) {
    Double temperature = weatherService.getTemperature(lat, lon);
    Map<String, Double> response = new HashMap<>();
    response.put("temperature", temperature);
    return ResponseEntity.ok().body(response);
}*/
    @GetMapping(value = "/weather")
    public Double getTemperature(@RequestParam Double lat, @RequestParam Double lon) {
        Double temperature = weatherService.getTemperature(lat, lon);
                                    Map<String, Double> response = new HashMap<>();
        response.put("temperature", temperature);
        return temperature;
    }

    @GetMapping(value = "/test")
    public String test() {
        return "Test";
    }


}

