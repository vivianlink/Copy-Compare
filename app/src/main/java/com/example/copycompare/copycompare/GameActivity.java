package com.example.copycompare.copycompare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class GameActivity extends AppCompatActivity {

    private String catFilePath = "/app/src/main/res/drawable/cat.png";
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
        Toast.makeText(this,String.valueOf(compareBitmap(customCanvas.getBitmap(), imageToBitmap(catFilePath))), Toast.LENGTH_SHORT).show();
    }

    public Bitmap imageToBitmap(String filePath){
        Bitmap bMap = BitmapFactory.decodeFile(filePath);
        return bMap;
    }

    public int compareBitmap(Bitmap drawing, Bitmap actualImage){
        int precision = -1;

        return precision;
    }
}
