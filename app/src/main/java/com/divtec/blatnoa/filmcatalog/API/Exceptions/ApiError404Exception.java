package com.divtec.blatnoa.filmcatalog.API.Exceptions;

public class ApiError404Exception extends ApiErrorException {
    public ApiError404Exception(String url) {
        super("Not found. Please check your request.\nUrl: " + url);
    }
}