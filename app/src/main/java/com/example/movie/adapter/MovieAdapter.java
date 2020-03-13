package com.example.movie.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie.R;
import com.example.movie.model.MovieResult;
import com.example.movie.view.CustomOnItemClickListener;
import com.example.movie.view.DetailResultActivity;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Activity activity;
    private ArrayList<MovieResult> arrayList;

    public MovieAdapter(Activity activity, ArrayList<MovieResult> arrayList) {
        this.activity = activity;
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_list_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieResult result = arrayList.get(position);

        String url_poster = "https://image.tmdb.org/t/p/w300_and_h450_bestv2/" + result.getPoster_path();
        Glide.with(activity).load(url_poster).into(holder.ivPoster);
        holder.tvTitle.setText(result.getOriginal_title());
        holder.tvLanguage.setText(result.getOriginal_language());
        holder.tvDate.setText(result.getDate());
        holder.cvMovie.setOnClickListener(new CustomOnItemClickListener(position, ((view, position1) -> {
            Intent intent = new Intent(activity, DetailResultActivity.class);
            intent.putExtra(DetailResultActivity.EXTRA_RESULT, result);
            activity.startActivity(intent);
        })));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        CardView cvMovie;
        TextView tvTitle, tvDate, tvLanguage;
        ImageView ivPoster;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            cvMovie = itemView.findViewById(R.id.cv_movie);
            tvTitle = itemView.findViewById(R.id.tv_original_title);
            tvLanguage = itemView.findViewById(R.id.tv_original_language);
            tvDate= itemView.findViewById(R.id.tv_release_date);
            ivPoster = itemView.findViewById(R.id.iv_poster);

        }
    }
}
