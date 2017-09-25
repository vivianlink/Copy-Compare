package com.example.copycompare.copycompare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
    }

    public void clickOK(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
