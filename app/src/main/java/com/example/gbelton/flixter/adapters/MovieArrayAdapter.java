package com.example.gbelton.flixter.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gbelton.flixter.R;
import com.example.gbelton.flixter.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by gbelton on 6/15/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get data item for this postion
        Movie movie = getItem(position);

        //check if existing view is being reused
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie,parent,false);
        }
        //find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);

        //clear out image from convert view
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        TextView tvScore = (TextView) convertView.findViewById(R.id.tvScore);

        //TextView title2 = (TextView) convertView.findViewById(R.id.tvTitle);

        //if (tvTitle.)
        Typeface titleFont = Typeface.createFromAsset(getContext().getAssets(), "fonts/titleFont3.ttf");
        tvTitle.setTypeface(titleFont);

        //populate data
        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());
        tvScore.setText(movie.getScore());

        boolean isLandscape = getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if (isLandscape) {
            Picasso.with(getContext()).load(movie.getBackdropPath()).into(ivImage);
        } else {
            Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        }

            //Picasso.with(getContext()).load(movie.getBackdropPath()).into(ivImage);

            //Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);



        //return the view that was just populated

        return convertView;

    }
}
