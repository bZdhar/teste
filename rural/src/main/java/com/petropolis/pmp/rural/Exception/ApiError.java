package com.petropolis.pmp.rural.Exception;


import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;


public class ApiError{
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public HttpStatus getStatus() {
      return status;
    }

    public void setStatus(HttpStatus status) {
      this.status = status;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public List<String> getErrors() {
      return errors;
    }

    public void setErrors(List<String> errors) {
      this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

    public ApiError(HttpStatusCode status2, String message2, List<String> errors2) {
        super();
        this.status = (HttpStatus) status2;
        this.message = message2;
        errors = errors2;
    }

    public ApiError(HttpStatusCode status, String message, String error) {
        super();
        this.status = (HttpStatus) status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}