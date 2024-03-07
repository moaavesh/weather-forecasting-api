package com.apple.weatherforecast.solution.service;

import com.apple.weatherforecast.solution.model.WeatherForecastDetail;
import com.apple.weatherforecast.solution.model.WeatherForecastRequest;

public interface WeatherForecastQueryService {
    WeatherForecastDetail processQuery(WeatherForecastRequest request);
}
