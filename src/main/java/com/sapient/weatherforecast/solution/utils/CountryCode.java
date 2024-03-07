package com.sapient.weatherforecast.solution.utils;

public enum CountryCode {
    India("in"),
    USA("us");

    private String countryCode;

    CountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
