package com.divtec.blatnoa.filmcatalog.API.Exceptions;

public class ApiErrorException extends RuntimeException {
    public ApiErrorException(String message) {
        super(message);
    }
}
