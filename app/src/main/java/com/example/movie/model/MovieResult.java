package com.example.movie.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResult implements Parcelable {
    @SerializedName("poster_path")
    @Expose
    private String poster_path;
    @SerializedName("original_title")
    @Expose
    private String original_title;
    @SerializedName("release_date")
    @Expose
    private String date;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("original_language")
    @Expose
    private String original_language;

    public MovieResult() {
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }


    /**
     *
     * @param in
     */


    protected MovieResult(Parcel in) {
        poster_path = in.readString();
        original_title = in.readString();
        date = in.readString();
        overview = in.readString();
        original_language = in.readString();
    }

    public static final Creator<MovieResult> CREATOR = new Creator<MovieResult>() {
        @Override
        public MovieResult createFromParcel(Parcel in) {
            return new MovieResult(in);
        }

        @Override
        public MovieResult[] newArray(int size) {
            return new MovieResult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(poster_path);
        dest.writeString(original_title);
        dest.writeString(date);
        dest.writeString(overview);
        dest.writeString(original_language);
    }

}
