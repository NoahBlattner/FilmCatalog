package com.divtec.blatnoa.filmcatalog.API.ApiObjects;

public class Top250Movie extends SearchResult {

    private String rank;
    private String fullTitle;
    private String year;
    private String crew;
    private String imDbRating;
    private String imDbRatingCount;

    protected Top250Movie(String id, String resultType, String image, String title, String description, String rank, String fullTitle, String year, String crew, String imDbRating, String imDbRatingCount) {
        super(id, resultType, image, title, description);
        this.rank = rank;
        this.fullTitle = fullTitle;
        this.year = year;
        this.crew = crew;
        this.imDbRating = imDbRating;
        this.imDbRatingCount = imDbRatingCount;
    }

    public String getRank() {
        return rank;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public String getYear() {
        return year;
    }

    public String getCrew() {
        return crew;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public String getImDbRatingCount() {
        return imDbRatingCount;
    }

}
