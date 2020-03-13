package com.example.movie.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.movie.R;
import com.example.movie.adapter.MovieAdapter;
import com.example.movie.model.MovieResult;
import com.example.movie.viewmodel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter adapter;
    private RecyclerView recyclerView;
    private MovieViewModel movieViewModel;

    private static  final  String LANGUAGE = "en-US";
    private static  final  String SORT = "popularity.desc";
    private static  final  String ADULT = "false";
    private static  final  String VIDEO = "false";
    private static  final  String PAGE = "1";

    private ArrayList<MovieResult> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_movie);

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.setMovie(LANGUAGE, SORT, ADULT, VIDEO, PAGE);
        movieViewModel.getMovie().observe(this, movieRequest -> {
            List<MovieResult> list = movieRequest.getResults();
            results.addAll(list);
            adapter.notifyDataSetChanged();

        });
        setupRecyclerView();
    }

    private void setupRecyclerView(){
        if (adapter == null){
            adapter = new MovieAdapter(MainActivity.this, results);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setNestedScrollingEnabled(true);
        }else{
            adapter.notifyDataSetChanged();
        }
    }
}
