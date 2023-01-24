package com.divtec.blatnoa.filmcatalog.API;

public class UnknownApiErrorException extends ApiErrorException {
    public UnknownApiErrorException(String url) {
        super("Unknown error. Please check your request.\nUrl: " + url);
    }
}
