package com.example.gilbertisu.quizapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main3Activity extends AppCompatActivity {
    int correct;
    int score;
    TextView sc;
    Random Rand = new Random();
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
         sc = findViewById(R.id.score1);
        correct = getIntent().getExtras().getInt("crt");
        score = getIntent().getExtras().getInt("scr");
        sc.setText(""+score);
        myDialog = new Dialog(this);

    }
    public void next1(View view){
        Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
        RadioButton plu = (RadioButton) findViewById(R.id.good1);
        boolean rightAns = plu.isChecked();

        if ( rightAns == true) {
            correct = ++correct;
            score = score + 10;
            display(score);
            int right = 1 + Rand.nextInt(3);

            switch (right) {
                case 1:
                    Toast.makeText(getApplicationContext(),"THAT IS CORRECT!!!",Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    Toast.makeText(getApplicationContext(),"Very good!!!!",Toast.LENGTH_LONG).show();
                    break;
                case 3:
                    Toast.makeText(getApplicationContext(),"Keep up the good work!!!",Toast.LENGTH_LONG).show();
            }}

        else
        {
            int wrong = 1 + Rand.nextInt(3);
            score = score;
            switch (wrong) {
                case 1:
                    Toast.makeText(getApplicationContext(),"THAT IS WRONG!!!",Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(getApplicationContext(),"WRONG!!!",Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(getApplicationContext(),"ALMOST BUT WRONG!!",Toast.LENGTH_SHORT).show();
            }}



        Toast.makeText(getApplicationContext(),"You have " + correct + " Correct Answer",Toast.LENGTH_LONG).show();
        intent.putExtra("crt",correct);
        intent.putExtra("scr",score);
        startActivity(intent);

    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.score1);
        quantityTextView.setText("" + number);
    }
    /**
     *Disable back button
     * Calls up pop up box instead
     */
    @Override
    public void onBackPressed() {
        Button tclose;
        Button menu;
        Button close;
        myDialog.setContentView(R.layout.activity_main11);
        tclose =(Button) myDialog.findViewById(R.id.closs);
        menu = (Button) myDialog.findViewById(R.id.main_menu);
        close = (Button) myDialog.findViewById(R.id.quit);
        tclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.finishAffinity(Main3Activity.this);
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}