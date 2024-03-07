package com.apple.weatherforecast.solution.configuration;

import com.apple.weatherforecast.solution.cache.CacheService;
import com.apple.weatherforecast.solution.model.WeatherForecastDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfigBean {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CacheService<WeatherForecastDetail> createCache() {
        return new CacheService<WeatherForecastDetail>();
    }
}
