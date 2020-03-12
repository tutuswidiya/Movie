package com.example.movie.apihelper;

import com.example.movie.model.MovieRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie")
    Call<MovieRequest> getMovieList(@Query("sources") String source,
                                   @Query("apikey") String apiKey);;
}
