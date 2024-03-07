package com.apple.weatherforecast.solution.utils;

public class TempretureUtil {
    public static float convertKelvinToCel(double temp) {
        return Math.round(((float) temp) - 273.15F);
    }
}
