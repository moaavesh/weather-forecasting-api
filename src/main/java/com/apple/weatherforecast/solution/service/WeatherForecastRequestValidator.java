package com.apple.weatherforecast.solution.service;

import com.apple.weatherforecast.solution.exception.WeatherForecastServiceException;
import com.apple.weatherforecast.solution.model.WeatherForecastRequest;
import org.springframework.stereotype.Service;


@Service
public class WeatherForecastRequestValidator {
    public  void validate(WeatherForecastRequest request){
        String zipCode = request.getZipCode();
        if(zipCode == null || zipCode.isEmpty()) throw new WeatherForecastServiceException("Zipcode is empty");
        if(zipCode.length()<6) throw new WeatherForecastServiceException("Zipcode entered is incorrect");
    }
}
