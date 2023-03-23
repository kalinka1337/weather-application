package com.meawallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpHeaders;
import java.util.Optional;
//import com.meawallet.WeatherRepository;



@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public Double getTemperature(Double latitude, Double longitude) {
        // Check if weather data exists in the cache
        Optional<WeatherData> weatherDataOptional = weatherRepository.findByLatitudeAndLongitude(latitude, longitude);
        if (weatherDataOptional.isPresent()) {
            return weatherDataOptional.get().getTemperature();
        }

        // If weather data is not in the cache, retrieve it from the 3rd party weather API
        Double temperature = retrieveTemperatureFromAPI(latitude, longitude);

        // Save the retrieved weather data to the cache
        WeatherData weatherData = WeatherData.builder()
                .latitude(latitude)
                .longitude(longitude)
                .temperature(temperature)
                .timestamp(System.currentTimeMillis())
                .build();
        weatherRepository.save(weatherData);

        return temperature;
    }


    private Double retrieveTemperatureFromAPI(Double latitude, Double longitude) {
        // Make a call to a weather API or use any other method to retrieve the temperature
        // In this example, we just return a hardcoded temperature
        return 15.2;
    }



}

