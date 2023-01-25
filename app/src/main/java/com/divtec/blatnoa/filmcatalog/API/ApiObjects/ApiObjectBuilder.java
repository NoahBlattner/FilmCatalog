package com.divtec.blatnoa.filmcatalog.API.ApiObjects;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ApiObjectBuilder {
    public static <T extends JsonConvertible> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return new Gson().fromJson(json, classOfT);
    }
}
