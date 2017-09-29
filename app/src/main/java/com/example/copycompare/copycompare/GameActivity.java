package com.example.copycompare.copycompare;

import android.content.Intent;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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

}
