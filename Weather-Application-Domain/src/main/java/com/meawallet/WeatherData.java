package com.meawallet;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class WeatherData
{
    double temperature;
    double latitude;
    double longitude;
    double timestamp;

}
