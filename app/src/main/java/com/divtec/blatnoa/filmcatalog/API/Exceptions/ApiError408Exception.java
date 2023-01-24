package com.divtec.blatnoa.filmcatalog.API.Exceptions;

public class ApiError408Exception extends ApiErrorException {
    public ApiError408Exception(String url) {
        super("Request timeout. Please check your connection.\nUrl: " + url);
    }
}