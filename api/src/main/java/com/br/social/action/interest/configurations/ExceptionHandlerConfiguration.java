package com.br.social.action.interest.configurations;

import com.br.social.action.interest.exceptions.ErrorResponse;
import com.br.social.action.interest.rules.BusinessRuleValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerConfiguration {

    @ExceptionHandler(BusinessRuleValidationException.class)
    public ResponseEntity<ErrorResponse> businessRuleValidationException(BusinessRuleValidationException exception) {
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponse response = new ErrorResponse(status.value(), LocalDateTime.now(), exception.id, exception.message);

        return new ResponseEntity<>(response, status);
    }
}
