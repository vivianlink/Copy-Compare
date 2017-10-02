package com.example.copycompare.copycompare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class GameActivity extends AppCompatActivity {

    private CanvasView customCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        customCanvas = (CanvasView) findViewById(R.id.drawing_canvas);
    }

    public void clearCanvas(View v) {
        customCanvas.clearCanvas();
    }

    public void clickCat(View view){
        Intent intent = new Intent(this, CatActivity.class);
        startActivity(intent);
    }

    public void clickSubmit(View view){
//        Toast.makeText(this,String.valueOf(compareBitmap(customCanvas.getBitmap(), imageToBitmap("cat"))), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ResultActivity.class);

        saveBitmap(intent);
        saveScore(intent);
        startActivity(intent);
    }

    private Bitmap imageToBitmap(String fileName){
        int imageID = getResources().getIdentifier(fileName, "drawable", getPackageName());
        return BitmapFactory.decodeResource(getResources(), imageID);
    }

    private void saveBitmap(Intent intent){
        Bitmap bmp = customCanvas.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        intent.putExtra("drawing", byteArray);
    }

    private void saveScore(Intent intent){
        intent.putExtra("score", compareBitmap(customCanvas.getBitmap(), imageToBitmap("cat")));
    }

    public int compareBitmap(Bitmap drawing, Bitmap actualImage){


        int aHeight;
        int aWidth;
        int precision = 0;


        if (actualImage.getHeight() < drawing.getHeight()){
            aHeight = actualImage.getHeight();
        } else {
            aHeight = drawing.getHeight();
        }

        if (actualImage.getWidth() < drawing.getWidth()){
            aWidth = actualImage.getWidth();
        } else {
            aWidth = drawing.getWidth();
        }

        double totalPixel = aHeight * aWidth;

        for (int y = 0; y < aHeight; y++) {
            for (int x = 0; x < aWidth; x++) {

                int drawingColor = drawing.getPixel(x, y);
                int actualImageColor = actualImage.getPixel(x, y);
                if (drawingColor == actualImageColor && drawingColor != 0) {
                    precision += 1;
                }
            }
        }
        return precision;
    }
}
