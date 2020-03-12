package com.example.movie.view;

import android.view.View;

public class CustomOnItemClickCallback implements View.OnClickListener {
    private int position;
    private OnItemClickCallback onItemClickCallback;

    public CustomOnItemClickCallback(int position, OnItemClickCallback onItemClickCallback) {
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onClick(View view) {
        onItemClickCallback.onItemClicked(view, position);
    }

    public interface OnItemClickCallback {
        void onItemClicked(View view, int position);
    }
}
