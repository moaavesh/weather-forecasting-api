package com.apple.weatherforecast.solution.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class WeatherForecastDetail {
    String date;
    Double currentTemp;
    Float maxTemp;
    Float minTemp;
    Float pressure;
    String description;
    String advisory;
    Location location;
}
