package com.meawallet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherService {

    private static final String API_URL_TEMPLATE = "https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=%s&lon=%s";

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public WeatherService() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public Double getTemperature(Double latitude, Double longitude) throws Exception {
        String apiUrl = String.format(API_URL_TEMPLATE, latitude, longitude);
        String apiResponse = fetchApiData(apiUrl);
        JsonNode apiData = objectMapper.readTree(apiResponse);
        Double temperature = extractTemperature(apiData);
        return temperature;
    }

    private String fetchApiData(String apiUrl) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new Exception("Failed to retrieve temperature data from API: " + response.body());
        }
        return response.body();
    }

    private Double extractTemperature(JsonNode apiData) {
        JsonNode temperatureNode = apiData.at("/properties/timeseries/0/data/instant/details/air_temperature");
        return temperatureNode.asDouble();
    }

}

