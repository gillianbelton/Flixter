package com.example.gbelton.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by gbelton on 6/15/16.
 */
public class Movie {

    public String posterPath;
    public String title;
    public String overview;
    public String score;
    public String backdropPath;
    public int rating;
    public String posterUrl;
    public String releaseDate;

    public Movie(JSONObject jsonObject) throws JSONException{
        this.posterPath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.score = jsonObject.getString("vote_average");
        this.releaseDate = jsonObject.getString("release_date");
        this.posterUrl = posterUrl;
        this.rating = rating;
    }


    //command N, generate Constructor, select all variables
    public Movie(String title, String posterUrl, int rating) {
        this.posterUrl = posterUrl;
        this.title = title;
        this.rating = rating;
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        ArrayList<Movie> results = new ArrayList<>();

        for (int x = 0; x < array.length(); x++){
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    public static ArrayList<Movie> getFakeMovies(){
        ArrayList<Movie> movies = new ArrayList<>();
        for(int i = 0; i<60; i++) {
            movies.add(new Movie("The Social Network", "", 75));
            movies.add(new Movie("The Internship", "", 50));
            movies.add(new Movie("The Lion King", "", 100));
        }
        return movies;
    }

    //@Override
    //public String toString() {
    //    return title + " - " + rating;
    //}


    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public int getRating() {
        return rating;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w780/%s", backdropPath);
    }
    public String getScore() {
        return score + "/10";
    }

    public String getReleaseDate() {
        return "Release Date: " + releaseDate;
    }
}

