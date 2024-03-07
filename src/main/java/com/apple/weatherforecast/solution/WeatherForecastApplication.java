package com.apple.weatherforecast.solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WeatherForecastApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeatherForecastApplication.class, args);
    }
}
