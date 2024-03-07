package com.apple.weatherforecast.solution.controller;

import com.apple.weatherforecast.solution.cache.CacheService;
import com.apple.weatherforecast.solution.exception.WeatherForecastServiceException;
import com.apple.weatherforecast.solution.model.WeatherForecastDetail;
import com.apple.weatherforecast.solution.model.WeatherForecastRequest;
import com.apple.weatherforecast.solution.service.WeatherForecastQueryService;
import com.apple.weatherforecast.solution.utils.Source;
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

    @Autowired
    private CacheService<WeatherForecastDetail> cacheService;

    @RequestMapping("/{zipcode}")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<WeatherForecastDetail> weatherForecast(@PathVariable("zipcode") String zipcode) {
        try {
            WeatherForecastDetail forecastDetail= WeatherForecastDetail.builder().build();
            if(cacheService.containsKey(zipcode)){
                 forecastDetail = cacheService.get(zipcode);
                 forecastDetail.setSource(Source.CACHED);
            }else {
                WeatherForecastRequest weatherForecastRequest = WeatherForecastRequest.builder().zipCode(zipcode).build();
                forecastDetail = weatherQueryService.processQuery(weatherForecastRequest);
                cacheService.addKey(zipcode, forecastDetail);
            }
            return new ResponseEntity(forecastDetail, HttpStatus.OK);
        } catch (WeatherForecastServiceException exe) {
            throw exe;
        }
    }
}
