package com.apple.weatherforecast.solution.service;

import com.apple.weatherforecast.solution.exception.WeatherForecastServiceException;
import com.apple.weatherforecast.solution.model.WeatherForecastDetail;
import com.apple.weatherforecast.solution.model.WeatherForecastRequest;
import com.apple.weatherforecast.solution.model.WeatherResponse;
import com.apple.weatherforecast.solution.rule.WeatherForecastingRuleService;
import com.apple.weatherforecast.solution.utils.Source;
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
            forecastDetail.setSource(Source.LIVE);
            return forecastDetail;
        } catch (Exception ee) {
            throw new WeatherForecastServiceException("Data could not fetch successfully"+ ee.getMessage());
        }
    }
}

