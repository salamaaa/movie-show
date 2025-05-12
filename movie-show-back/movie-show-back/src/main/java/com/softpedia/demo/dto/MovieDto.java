package com.softpedia.demo.dto;


public class MovieDto {
    private String imdbId;
    private String title;
    private String year;
    private String posterUrl;
    private String plot;

    public MovieDto() {
    }

    public MovieDto(String imdbId, String title, String year, String posterUrl, String plot) {
        this.imdbId = imdbId;
        this.title = title;
        this.year = year;
        this.posterUrl = posterUrl;
        this.plot = plot;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
