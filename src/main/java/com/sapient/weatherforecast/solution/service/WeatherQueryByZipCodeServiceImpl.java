package com.sapient.weatherforecast.solution.service;

import com.sapient.weatherforecast.solution.exception.WeatherForecastServiceException;
import com.sapient.weatherforecast.solution.model.WeatherForecastDetail;
import com.sapient.weatherforecast.solution.model.WeatherForecastRequest;
import com.sapient.weatherforecast.solution.model.WeatherResponse;
import com.sapient.weatherforecast.solution.rule.WeatherForecastingRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("weatherQueryServiceByZipCode")
@Slf4j
public class WeatherQueryByZipCodeServiceImpl implements WeatherForecastQueryService {

    @Autowired
    @Qualifier("queryByZipCode")
    private WeatherQueryExecutor weatherQueryExecutor;
    @Autowired
    private WeatherForecastRequestValidator weatherForecastRequestValidator;
    @Autowired
    private WeatherForecastingRuleService weatherForecastingRuleService;

    @Override
    public WeatherForecastDetail processQuery(WeatherForecastRequest request) {
        try {
            weatherForecastRequestValidator.validate(request);
            final WeatherResponse weatherResponse = weatherQueryExecutor.execute(request);
            final WeatherForecastDetail forecastDetail = weatherForecastingRuleService.applyRules(weatherResponse);
            return forecastDetail;
        } catch (Exception ee) {
            throw new WeatherForecastServiceException("Data could not fetch successfully"+ ee.getMessage());
        }
    }
}

