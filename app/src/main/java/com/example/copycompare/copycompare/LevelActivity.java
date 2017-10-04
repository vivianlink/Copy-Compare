package com.example.copycompare.copycompare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class LevelActivity extends AppCompatActivity {


    private TextView levelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_level);
    }

    public void clickCat(View view){
        Intent intent = new Intent(this, CatActivity.class);
        startActivity(intent);

        levelView = (TextView) findViewById(R.id.level3);
        levelView.setAlpha(0.5f);
    }
}
