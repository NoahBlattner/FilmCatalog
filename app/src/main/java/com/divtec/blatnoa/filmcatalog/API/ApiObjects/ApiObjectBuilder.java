package com.divtec.blatnoa.filmcatalog.API.ApiObjects;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ApiObjectBuilder {
    /**
     * Converts a JSON string to an object of the specified class
     * @param json JSON string
     * @param classOfT Class of the object to convert to
     * @param <T>
     * @return Object of the specified class built from the JSON string
     * @throws JsonSyntaxException
     */
    public static <T extends JsonConvertible> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return new Gson().fromJson(json, classOfT);
    }
}
