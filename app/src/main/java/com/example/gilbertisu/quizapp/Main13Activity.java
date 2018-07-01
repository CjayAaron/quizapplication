package com.example.gilbertisu.quizapp;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main13Activity extends AppCompatActivity {
    int score;
    TextView sc;
    Dialog myDialog;
    String g1 = " YOU ARE A NIGERIAN";
    String g2 = " YOU ARE HUMAN";
    String g3 = " YOU ARE FROM EARTH";
    String g4 = " YOU ARE AN AWESOME NIGERIAN";
    String g5 = " YOU ARE A SUPER AWESOME NIGERIAN";
    String g6 = " YOU ARE THE ULTIMATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        sc = findViewById(R.id.score10);
        score = getIntent().getExtras().getInt("scr");
        sc.setText("" + score);
        MediaPlayer sing = MediaPlayer.create(Main13Activity.this, R.raw.building);
        sing.start();
        myDialog = new Dialog(this);
        if (score == 50) {
            display(g1);
        }
        else if (score <= 30) {
            display(g3);
        }
        else if (score == 40) {
            display(g2);
        }
        else if (score == 60) {
            display(g4);
        }
        else if (score >= 70) {
            display(g5);
        }
        else if (score == 100) {
            display(g6);
        }

    }
    public void Restart(View view) {
        MediaPlayer sing = MediaPlayer.create(Main13Activity.this, R.raw.glovebox);

        sing.start();
        Intent intent = new Intent(Main13Activity.this, Main2Activity.class);
        startActivity(intent);
    }
    public void mail(View view) {

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, "Score Sheet");
            intent.putExtra(Intent.EXTRA_TEXT,"YOUR SCORED" + score);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

    }
    private void display(String cal) {
        TextView quantityTextView = (TextView) findViewById(R.id.message);
        quantityTextView.setText(cal);
    }
}