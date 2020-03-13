package com.example.movie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movie.R;
import com.example.movie.model.MovieResult;

public class DetailResultActivity extends AppCompatActivity {

    ImageView ivImage;
    TextView tvTitle, tvLanguage, tvDate, tvOverview;
    public  static final  String EXTRA_RESULT= "extra_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_result);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initContent();

        MovieResult result = getIntent().getParcelableExtra(EXTRA_RESULT);
        if (result != null) {
            String image = "https://image.tmdb.org/t/p/w300_and_h450_bestv2/" +result.getPoster_path();
            String title = result.getOriginal_title();
            String date = result.getDate();
            String language= result.getOriginal_language();
            String overview = result.getOverview();

            Glide.with(this).load(image).into(ivImage);
            tvTitle.setText(title);
            tvDate.setText(date);
            tvLanguage.setText(language);
            tvOverview.setText(overview);
        }
    }
    private void initContent(){
        ivImage = findViewById(R.id.iv_poster);
        tvTitle = findViewById(R.id.tv_original_title);
        tvDate = findViewById(R.id.tv_release_date);
        tvOverview = findViewById(R.id.tv_overview);
        tvLanguage = findViewById(R.id.tv_original_language);
    }
}



