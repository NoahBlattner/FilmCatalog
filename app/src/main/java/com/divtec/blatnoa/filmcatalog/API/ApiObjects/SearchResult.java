package com.divtec.blatnoa.filmcatalog.API.ApiObjects;

public class SearchResult extends ApiObject {

    public String ResultType;
    public String Image;
    public String Title;
    public String Description;

    /**
     * Constructor for Movie, accessible only from package -> ApiObjectBuilder
     * @param id
     * @param resultType
     * @param image
     * @param title
     * @param description
     */
    protected SearchResult(String id, String resultType, String image, String title, String description) {
        super(id);
        Id = id;
        ResultType = resultType;
        Image = image;
        Title = title;
        Description = description;
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
