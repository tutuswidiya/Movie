package com.example.movie.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieRequest {
    @SerializedName("results")
    @Expose
    private List<MovieResult> results;
    @SerializedName("page")
    @Expose
    private List<MovieResult> page;

    public MovieRequest() {
    }


    public List<MovieResult> getPage() {

        return page;
    }

    public void setPage(List<MovieResult> page) {
        this.page = page;
    }


    public List<MovieResult> getResults() {

        return results;
    }

    public void setResults(List<MovieResult> results) {
        this.results = results;
    }
}
