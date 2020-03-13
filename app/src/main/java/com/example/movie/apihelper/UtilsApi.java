package com.example.movie.apihelper;


public class UtilsApi {
    static final String BASE_URL = "https://api.themoviedb.org/3/discover/";

    public  static ApiService getApiService(){
        return ApiClient.getClient().create(ApiService.class);
    }
}
