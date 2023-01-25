package com.divtec.blatnoa.filmcatalog.API.ApiObjects;

public class Top250MovieResult extends TitledResult {

    private String rank;
    private String fullTitle;
    private String year;
    private String crew;
    private String imDbRating;
    private String imDbRatingCount;

    protected Top250MovieResult(String id, String rank, String title, String fullTitle, String year, String image, String crew, String imDbRating, String imDbRatingCount) {
        super(id, title, image);
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
