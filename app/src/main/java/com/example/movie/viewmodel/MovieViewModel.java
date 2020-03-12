package com.example.movie.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movie.BuildConfig;
import com.example.movie.apihelper.ApiService;
import com.example.movie.apihelper.UtilsApi;
import com.example.movie.model.MovieRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    private  static  final  String API_TOKEN = BuildConfig.API_KEY;

    private MutableLiveData<MovieRequest> liveDataMovie = new MutableLiveData<>();

    public void setMovie(String sources){
        ApiService mApiService = UtilsApi.getApiService();
        Call<MovieRequest> call = mApiService.getMovieList(sources, API_TOKEN);
        call.enqueue(new Callback<MovieRequest>() {
            @Override
            public void onResponse(Call<MovieRequest> call, Response<MovieRequest> response) {
                liveDataMovie.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieRequest> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });
    }

    public LiveData<MovieRequest> getMovie(){
        return  liveDataMovie;
    }
}
