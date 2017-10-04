package com.example.copycompare.copycompare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    String easy_lvl = "easy";
    String hard_lvl = "hard";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    public void clickEasy(View view){
        Intent intent = new Intent(this, LevelActivity.class);
        intent.putExtra("difficulty", easy_lvl);
        startActivity(intent);
    }

    public void clickHard(View view){
        Intent intent = new Intent(this, LevelActivity.class);
        intent.putExtra("difficulty", hard_lvl);
        startActivity(intent);
    }
}
