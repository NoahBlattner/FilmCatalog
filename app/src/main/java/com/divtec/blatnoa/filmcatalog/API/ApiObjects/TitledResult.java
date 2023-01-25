package com.divtec.blatnoa.filmcatalog.API.ApiObjects;

public class TitledResult extends ApiObject {
    private String title;
    private String image;

    protected TitledResult(String id, String title, String image) {
        super(id);
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
