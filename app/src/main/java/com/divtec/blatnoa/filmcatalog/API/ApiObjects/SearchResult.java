package com.divtec.blatnoa.filmcatalog.API.ApiObjects;

public class SearchResult extends TitledResult {

    public String ResultType;
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
        super(id, title, image);
        Id = id;
        ResultType = resultType;
        Description = description;
    }

    public String getId() {
        return Id;
    }

    public String getResultType() {
        return ResultType;
    }

    public String getDescription() {
        return Description;
    }
}
