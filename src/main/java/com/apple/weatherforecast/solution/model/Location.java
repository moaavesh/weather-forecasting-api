package com.apple.weatherforecast.solution.model;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    public double lat;
    public double lon;
    public String name;
    public String type;
}
