package com.sapient.weatherforecast.solution.service;

import com.sapient.weatherforecast.solution.model.WeatherForecastRequest;
import com.sapient.weatherforecast.solution.model.WeatherResponse;

public interface WeatherQueryExecutor {
    WeatherResponse execute(WeatherForecastRequest request);
}
