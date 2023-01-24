package com.divtec.blatnoa.filmcatalog.API;

public class ApiErrorException extends RuntimeException {
    public ApiErrorException(String message) {
        super(message);
    }
}
