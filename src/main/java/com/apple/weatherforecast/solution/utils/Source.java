package com.apple.weatherforecast.solution.utils;

public enum Source {
    LIVE("LIVE"),
    CACHED("CACHED");

    private String source;
    Source(String source) {
    this.source = source;
    }

    public String getSource() {
        return source;
    }
}
