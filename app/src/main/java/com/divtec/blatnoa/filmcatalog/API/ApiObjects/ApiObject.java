package com.divtec.blatnoa.filmcatalog.API.ApiObjects;

import com.google.gson.Gson;

public abstract class ApiObject {

    public String toJson() {
        return new Gson().toJson(this);
    }

}
