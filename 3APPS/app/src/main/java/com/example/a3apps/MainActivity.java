package com.example.a3apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAPP1OnClick(View view) {
        Intent intentAPP1 = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intentAPP1);
    }

    public void btnAPP2OnClick(View view) {
        Intent intentAPP2 = new Intent(MainActivity.this, Main3Activity.class);
        startActivity(intentAPP2);
    }

    public void btnAPP3OnClick(View view) {
        Intent intentAPP3 = new Intent(MainActivity.this, Main4Activity.class);
        startActivity(intentAPP3);
    }

    public void btnAPP4OnClick(View view) {
        Intent intentAPP4 = new Intent(MainActivity.this, Main5Activity.class);
        startActivity(intentAPP4);
    }

    public void btnAPP5OnClick(View view) {
        Intent intentAPP5 = new Intent(MainActivity.this, Main6Activity.class);
        startActivity(intentAPP5);
    }
}
