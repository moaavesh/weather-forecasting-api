package com.apple.weatherforecast.solution.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {
    @JsonProperty("time")
    public String time;
    @JsonProperty("values")
    public Values values;
}
