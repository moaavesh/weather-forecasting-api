package com.apple.weatherforecast.solution.service;

import com.apple.weatherforecast.solution.model.WeatherForecastRequest;
import com.apple.weatherforecast.solution.model.WeatherResponse;
import com.apple.weatherforecast.solution.utils.WeatherURIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@Component("queryByZipCode")
class WeatherQueryExecutorImpByZipCode implements WeatherQueryExecutor{

    @Value("${weather.api.url}")
    private String weatherForecastingApiUrl;
    @Value("${weather.apiKey}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    private WeatherResponse fetchWeatherForecastDataBy(String zipCode) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        final UriComponentsBuilder uriComponentsBuilder = WeatherURIBuilder.uriBuilder(zipCode, weatherForecastingApiUrl, apiKey);
        return restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, entity, WeatherResponse.class).getBody();
    }
    @Override
    public WeatherResponse execute(WeatherForecastRequest request) {
        final String zipCode = request.getZipCode();
        return fetchWeatherForecastDataBy(zipCode);
    }
}
