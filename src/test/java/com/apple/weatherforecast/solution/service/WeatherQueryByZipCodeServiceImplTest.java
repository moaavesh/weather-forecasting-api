package com.apple.weatherforecast.solution.service;

import com.apple.weatherforecast.solution.model.*;
import com.apple.weatherforecast.solution.rule.WeatherForecastingRuleService;
import com.apple.weatherforecast.solution.utils.Source;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherQueryByZipCodeServiceImplTest {

    @InjectMocks
    private WeatherQueryByZipCodeServiceImpl weatherQueryByZipCodeService;
    @Mock
    private WeatherQueryExecutor weatherQueryExecutor;
    @Mock
    private WeatherForecastRequestValidator validatorService;
    @Mock
    private WeatherForecastingRuleService weatherForecastingRuleService;

    @Before
    public void setup(){

    }

    @Test
    public void test_processQuery_When_ValidZipCode_Return_WeatherForecastingData(){
        WeatherForecastRequest weatherForecastRequest = WeatherForecastRequest.builder().zipCode("500081").build();
        WeatherResponse weatherResponse = WeatherResponse.builder().data(WeatherData.builder()
                                                 .values(Values.builder().temperature(20.0).cloudCover(45).windGust(1.2).build())
                                                 .time(new Date().toString()).build()).build();
        when(weatherQueryExecutor.execute(weatherForecastRequest)).thenReturn(weatherResponse);

        doNothing().when(validatorService).validate(weatherForecastRequest);

        WeatherForecastDetail  weatherForecastDetail = WeatherForecastDetail.builder().build();
        when(weatherForecastingRuleService.applyRules(weatherResponse)).thenReturn(weatherForecastDetail);

        WeatherForecastDetail result = weatherQueryByZipCodeService.processQuery(weatherForecastRequest);
        Assert.assertTrue(result.getSource().equals(Source.LIVE));
    }

}
