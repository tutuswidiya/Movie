package com.example.movie.apihelper;

import com.example.movie.model.MovieRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie")
    Call<MovieRequest> getMovieList( @Query("api_key") String apiKey,
                                     @Query("language") String language);
}