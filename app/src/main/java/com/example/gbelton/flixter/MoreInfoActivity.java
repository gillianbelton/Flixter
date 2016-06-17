package com.example.gbelton.flixter;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by gbelton on 6/16/16.
 */
public class MoreInfoActivity extends AppCompatActivity {

    TextView tvMoreTitle;
    TextView tvRelease;
    TextView tvMoreOverview;
    ImageView ivOtherPoster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);



        tvMoreTitle = (TextView) findViewById(R.id.tvMoreTitle);
        Typeface titleFont = Typeface.createFromAsset(getAssets(), "fonts/titleFont3.ttf");
        tvMoreTitle.setTypeface(titleFont);

        Typeface overViewFont = Typeface.createFromAsset(getAssets(), "fonts/Quattrocento-Regular.ttf");


        tvMoreTitle = (TextView) findViewById(R.id.tvMoreTitle);
        String title = getIntent().getStringExtra("title");
        tvMoreTitle.setText(title);

        tvRelease = (TextView) findViewById(R.id.tvRelease);
        String release = getIntent().getStringExtra("release");
        tvRelease.setText(release);

        tvMoreOverview = (TextView) findViewById(R.id.tvMoreOverview);
        String moreOverview = getIntent().getStringExtra("overview");
        //Typeface titleFont2 = Typeface.createFromAsset(getAssets(), "fonts/titleFont2.ttf");
        //tvMoreOverview.setTypeface(titleFont2);
        tvMoreOverview.setText(moreOverview);
        tvMoreOverview.setTypeface(overViewFont);




        ivOtherPoster = (ImageView) findViewById(R.id.ivOtherPoster);
        String posterURL = getIntent().getStringExtra("posterURL");
        Picasso.with(this).load(posterURL).transform(new RoundedCornersTransformation(10, 10)).into(ivOtherPoster);

        //Picasso.with(this).load(R.drawable.demo).transform(new RoundedCornersTransformation(10, 10)).into((ImageView) findViewById(R.id.image));





    }


}
