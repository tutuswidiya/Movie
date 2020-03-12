package com.example.movie.apihelper;

import com.example.movie.model.MovieRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class UtilsApi {
    static final String BASE_URL = "https://api.themoviedb.org/3/discover/";

    public  static ApiService getApiService(){
        return ApiClient.getClient().create(ApiService.class);
    }
}
