package com.apple.weatherforecast.solution.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    private String errorMessage;
}
