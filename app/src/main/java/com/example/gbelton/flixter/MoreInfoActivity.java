package com.example.gbelton.flixter;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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


        TextView title2 = (TextView) findViewById(R.id.tvMoreTitle);
        Typeface titleFont = Typeface.createFromAsset(getAssets(), "fonts/Wisdom Script AJ.ttf");
        title2.setTypeface(titleFont);

        tvMoreTitle = (TextView) findViewById(R.id.tvMoreTitle);
        String title = getIntent().getStringExtra("title");
        tvMoreTitle.setText(title);

        tvRelease = (TextView) findViewById(R.id.tvRelease);
        String release = getIntent().getStringExtra("release");
        tvRelease.setText(release);

        tvMoreOverview = (TextView) findViewById(R.id.tvMoreOverview);
        String moreOverview = getIntent().getStringExtra("overview");
        tvMoreOverview.setText(moreOverview);

        ivOtherPoster = (ImageView) findViewById(R.id.ivOtherPoster);
        String posterURL = getIntent().getStringExtra("posterURL");
        Picasso.with(this).load(posterURL).into(ivOtherPoster);



    }


}
