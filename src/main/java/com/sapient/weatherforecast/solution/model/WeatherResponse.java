package com.sapient.weatherforecast.solution.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {
    @JsonProperty("data")
    private WeatherData data;
    @JsonProperty("location")
    private Location location;
}
