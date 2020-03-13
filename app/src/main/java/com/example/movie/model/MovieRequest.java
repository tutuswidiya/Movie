package com.example.movie.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieRequest {
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("results")
    @Expose
    private List<MovieResult> results;


    public MovieRequest() {
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<MovieResult> getResults() {

        return results;
    }

    public void setResults(List<MovieResult> results) {
        this.results = results;
    }
}
