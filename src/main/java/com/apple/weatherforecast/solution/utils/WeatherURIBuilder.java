package com.apple.weatherforecast.solution.utils;

import org.springframework.web.util.UriComponentsBuilder;

public class WeatherURIBuilder {

    public static UriComponentsBuilder uriBuilder(String zipCode, String weatherForecastingApiUrl,String apiKey ) {

        final UriComponentsBuilder queryBuilder = UriComponentsBuilder.fromHttpUrl(weatherForecastingApiUrl)
                .queryParam("location", zipCode)
                .queryParam("apikey", apiKey);
        System.out.println(queryBuilder.toUriString());
        return queryBuilder;
    }
}
