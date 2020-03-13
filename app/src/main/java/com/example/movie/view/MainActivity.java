package com.example.movie.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.movie.R;
import com.example.movie.adapter.MovieAdapter;
import com.example.movie.model.MovieResult;
import com.example.movie.viewmodel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private MovieAdapter adapter;
    private RecyclerView recyclerView;
    private static  final  String LANGUAGE = "en-US";
    private ArrayList<MovieResult> results = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_movie);
        ProgressBar progressBar = findViewById(R.id.progressbar);

        MovieViewModel movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.setMovie(LANGUAGE);
        movieViewModel.getMovie().observe(this, movieRequest -> {
            List<MovieResult> list = movieRequest.getResults();
            results.addAll(list);
            adapter.notifyDataSetChanged();

        });
        setupRecyclerciew();
    }
    private void setupRecyclerciew(){
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