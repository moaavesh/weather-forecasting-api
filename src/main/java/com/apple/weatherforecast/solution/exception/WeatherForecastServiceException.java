package com.apple.weatherforecast.solution.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeatherForecastServiceException extends RuntimeException {
    public WeatherForecastServiceException(String errorMessage) {
        super(errorMessage);
    }
}
