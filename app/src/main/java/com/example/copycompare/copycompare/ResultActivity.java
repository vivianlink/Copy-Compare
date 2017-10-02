package com.example.copycompare.copycompare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class ResultActivity extends AppCompatActivity {

    private RatingBar stars;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ImageView oriImg = (ImageView) findViewById(R.id.oriImg);
        oriImg.setImageBitmap(pngToBitmap("cat"));

        saveDrawnImage();
        setRating(getScore());
    }


     protected void saveDrawnImage(){
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("drawing");

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView image = (ImageView) findViewById(R.id.drawnImg);

        image.setImageBitmap(bmp);
    }

    protected int getScore(){
        Bundle extras = getIntent().getExtras();
        return extras.getInt("score");
    }

    private Bitmap pngToBitmap(String fileName){
        int imageID = getResources().getIdentifier(fileName, "drawable", getPackageName());
        return BitmapFactory.decodeResource(getResources(), imageID);
    }

    private void setRating(int score) {
        stars = (RatingBar) findViewById(R.id.ratingBar);
        message = (TextView) findViewById(R.id.percentageView);

        if (score < 1) {
            stars.setRating(1);
            message.setText("Fail, try again!");
        } else if (score >= 5){
            stars.setRating(2);
            message.setText("passed, but not that great");
        } else if (score >=8){
            stars.setRating(3);
            message.setText("3/5, nice");
        } else if (score >=20){
            stars.setRating(4);
            message.setText("wow amazing!");
        } else {
            stars.setRating(40);
            message.setText("just ... perfect");
        }
    }
}
