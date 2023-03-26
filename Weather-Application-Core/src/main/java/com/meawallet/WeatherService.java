package com.meawallet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class WeatherService {

    private WeatherRepository weatherRepository;


    public Double getTemperature(Double latitude, Double longitude) {
        Double temperature = retrieveTemperatureFromAPI(latitude, longitude);
        return temperature;
    }

    private Double retrieveTemperatureFromAPI(Double latitude, Double longitude) {
        // make anyway return 15.2 :D
        return 15.2;
    }
}
