package com.divtec.blatnoa.filmcatalog.API.Exceptions;

import com.divtec.blatnoa.filmcatalog.API.Exceptions.ApiErrorException;

public class UnknownApiErrorException extends ApiErrorException {
    public UnknownApiErrorException(String url) {
        super("Unknown error. Please check your request.\nUrl: " + url);
    }
}
