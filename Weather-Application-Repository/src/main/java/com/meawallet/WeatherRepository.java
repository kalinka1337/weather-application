package com.meawallet;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeatherRepository extends JpaRepository<WeatherData, Long> {
    Optional<WeatherData> findByLatitudeAndLongitude(double latitude, double longitude);
}

