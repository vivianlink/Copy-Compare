package com.example.copycompare.copycompare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class ResultActivity extends AppCompatActivity {

    private String catFile = "/cat.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ImageView oriImg = (ImageView) findViewById(R.id.oriImg);
        oriImg.setImageBitmap(pngToBitmap(catFile));
        saveDrawnImage();
    }

    protected void saveDrawnImage (){
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("drawing");

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView image = (ImageView) findViewById(R.id.drawnImg);

        image.setImageBitmap(bmp);
    }

    public Bitmap pngToBitmap(String fileName){
        String fname =this.getFilesDir().getAbsolutePath()+ catFile;
        Toast.makeText(this, fname, Toast.LENGTH_LONG).show();
        Bitmap bMap = BitmapFactory.decodeFile(fname);
        return bMap;
    }
}