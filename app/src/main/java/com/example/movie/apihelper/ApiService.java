package com.example.movie.apihelper;

import com.example.movie.model.MovieRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
  

    @GET("movie")
    Call<MovieRequest> getMovieList(@Query("language") String language,
                                    @Query("sort_by") String sort_by,
                                    @Query("include_adult") String include_adult,
                                    @Query("include_video") String include_video,
                                    @Query("page") String page,
                                    @Query("api_key") String apiKey);
}