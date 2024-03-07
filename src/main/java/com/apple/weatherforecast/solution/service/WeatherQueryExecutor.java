package com.apple.weatherforecast.solution.service;

import com.apple.weatherforecast.solution.model.WeatherForecastRequest;
import com.apple.weatherforecast.solution.model.WeatherResponse;

public interface WeatherQueryExecutor {
    WeatherResponse execute(WeatherForecastRequest request);
}
