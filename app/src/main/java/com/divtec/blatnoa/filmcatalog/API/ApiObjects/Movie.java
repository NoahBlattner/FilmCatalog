package com.divtec.blatnoa.filmcatalog.API.ApiObjects;

public class Movie extends ApiObject {

    public String Id;
    public String ResultType;
    public String Image;
    public String Title;
    public String Description;

    protected Movie() {
    }

    public String getId() {
        return Id;
    }

    public String getResultType() {
        return ResultType;
    }

    public String getImage() {
        return Image;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }
}
