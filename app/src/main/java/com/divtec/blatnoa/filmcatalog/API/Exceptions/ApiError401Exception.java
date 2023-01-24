package com.divtec.blatnoa.filmcatalog.API.Exceptions;

public class ApiError401Exception extends ApiErrorException {
    public ApiError401Exception(String url) {
        super("Unauthorized. Please check your API key.\nUrl: " + url);
    }
}