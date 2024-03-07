package com.apple.weatherforecast.solution.controller;

import com.apple.weatherforecast.solution.model.WeatherForecastDetail;
import com.apple.weatherforecast.solution.service.WeatherForecastQueryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class WeatherForecastingAPIControllerTest {

    @MockBean
    private WeatherForecastQueryService weatherForecastQueryService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup(){

    }

    @Test
    public void test_weatherForecast_When_validZipCode_Return_WeatherForeCastDetail()
            throws Exception {

        final WeatherForecastDetail detail= WeatherForecastDetail.builder().date(new Date().toString()).advisory("Weather Looks Good").currentTemp(20.0).build();
        when(weatherForecastQueryService.processQuery(any())).thenReturn(detail);

        mockMvc.perform(get("/api/weather/{zipCode}", "500081")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentTemp").value(detail.getCurrentTemp()))
                .andExpect(jsonPath("$.advisory").value(detail.getAdvisory()))
                .andDo(print());;
    }
}
