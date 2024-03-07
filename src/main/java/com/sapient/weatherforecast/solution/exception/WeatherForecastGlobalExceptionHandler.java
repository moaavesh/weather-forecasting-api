package com.sapient.weatherforecast.solution.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class WeatherForecastGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(WeatherForecastServiceException.class)
    @ResponseBody
    public final ResponseEntity<ErrorMessage> handleUserNotFoundException(WeatherForecastServiceException ex, WebRequest
            request) {
        final ErrorMessage errorMessage = getErrorMessage(ex);
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    public ErrorMessage getErrorMessage(WeatherForecastServiceException ex) {
        return ErrorMessage.builder()
                .errorMessage(ex.getMessage())
                .build();
    }
}
