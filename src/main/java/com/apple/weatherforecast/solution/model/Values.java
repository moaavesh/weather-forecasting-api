package com.apple.weatherforecast.solution.model;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Values {
    public double cloudBase;
    public Object cloudCeiling;
    public int cloudCover;
    public double dewPoint;
    public int freezingRainIntensity;
    public int humidity;
    public int precipitationProbability;
    public double pressureSurfaceLevel;
    public int rainIntensity;
    public int sleetIntensity;
    public int snowIntensity;
    public double temperature;
    public double temperatureApparent;
    public int uvHealthConcern;
    public int uvIndex;
    public int visibility;
    public int weatherCode;
    public double windDirection;
    public double windGust;
    public double windSpeed;
}
