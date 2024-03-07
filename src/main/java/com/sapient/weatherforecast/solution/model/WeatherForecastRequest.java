package com.sapient.weatherforecast.solution.model;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherForecastRequest {
    private String zipCode;
    private String cityName;
}
