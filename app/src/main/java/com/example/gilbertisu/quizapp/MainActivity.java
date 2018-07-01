package com.example.gilbertisu.quizapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer sing = MediaPlayer.create(MainActivity.this, R.raw.anthem);//plays sound on button click
        sing.start();
    }
    public void play1(View view) {
        MediaPlayer sing = MediaPlayer.create(MainActivity.this, R.raw.glovebox);//plays sound on button click
        sing.start();
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);//creates intent to second activity
        startActivity(intent);//starts activity
    }
    /*
    * Exits on click
    * */
    public void exit1(View v) {
        MediaPlayer sing = MediaPlayer.create(MainActivity.this, R.raw.glovebox);
        sing.start();
        ActivityCompat.finishAffinity(MainActivity.this);
    }
}
