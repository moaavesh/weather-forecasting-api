package com.sapient.weatherforecast.solution.service;

import com.sapient.weatherforecast.solution.model.WeatherForecastDetail;
import com.sapient.weatherforecast.solution.model.WeatherForecastRequest;

public interface WeatherForecastQueryService {
    WeatherForecastDetail processQuery(WeatherForecastRequest request);
}
