package com.divtec.blatnoa.filmcatalog.API.ApiObjects;

import com.google.gson.Gson;

public abstract class ApiObject {

    public String Id;

    protected ApiObject(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

}
