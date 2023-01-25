package com.divtec.blatnoa.filmcatalog.API.ApiObjects;

import com.google.gson.Gson;

public abstract class ImdbApiObject implements JsonConvertible {

    public String Id;

    protected ImdbApiObject(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

}
