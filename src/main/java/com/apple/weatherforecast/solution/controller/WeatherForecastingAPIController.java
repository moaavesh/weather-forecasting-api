package com.apple.weatherforecast.solution.controller;

import com.apple.weatherforecast.solution.exception.WeatherForecastServiceException;
import com.apple.weatherforecast.solution.model.WeatherForecastDetail;
import com.apple.weatherforecast.solution.model.WeatherForecastRequest;
import com.apple.weatherforecast.solution.service.WeatherForecastQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherForecastingAPIController {

    @Autowired
    @Qualifier("weatherQueryServiceByZipCode")
    private WeatherForecastQueryService weatherQueryService;

    @RequestMapping("/{zipcode}")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<WeatherForecastDetail> weatherForecast(@PathVariable("zipcode") String zipcode) {
        try {
            WeatherForecastRequest weatherForecastRequest = WeatherForecastRequest.builder().zipCode(zipcode).build();
            WeatherForecastDetail forecastDetail = weatherQueryService.processQuery(weatherForecastRequest);
            return new ResponseEntity(forecastDetail, HttpStatus.OK);
        } catch (WeatherForecastServiceException exe) {
            throw exe;
        }
    }
}
