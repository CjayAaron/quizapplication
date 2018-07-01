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
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Scanner;

public class Main5Activity extends AppCompatActivity {
    int correct;
    int score;
    String cAns = "Taiwo Akinkunmi";
    TextView answer;
    String ans;
    TextView sc;
    Random Rand = new Random();
    Dialog myDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        correct = getIntent().getExtras().getInt("crt");
        sc = findViewById(R.id.score3);
        score = getIntent().getExtras().getInt("scr");
        sc.setText(""+score);
        myDialog = new Dialog(this);
    }



    public void next3(View view){
        Intent intent = new Intent(Main5Activity.this, Main6Activity.class);
         answer = (TextView) findViewById(R.id.anss);
         ans = answer.getText().toString();
        if ( ans.equals(cAns)) {
            correct = ++correct;
            score = score + 10;
            display(score);
            int right = 1 + Rand.nextInt(3);

            switch (right) {
                case 1:
                    Toast.makeText(getApplicationContext(),"YOUR ANSWERED: "+ ans +" THAT IS CORRECT!!!",Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(getApplicationContext(),"YOUR ANSWERED: "+ ans +" Very good!!!!",Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(getApplicationContext(),"YOUR ANSWERED: "+ ans +" CORRECT!!! Keep up the good work!!!",Toast.LENGTH_SHORT).show();
            }}
        else
        {
            int wrong = 1 + Rand.nextInt(3);

            switch (wrong) {
                case 1:
                    Toast.makeText(getApplicationContext(),"YOUR ANSWERED: "+ ans +" THAT IS WRONG!!!",Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(getApplicationContext(),"YOUR ANSWERED: "+ ans +" WRONG!!!",Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(getApplicationContext(),"YOUR ANSWERED: "+ ans + " YOU ARE WRONG!!",Toast.LENGTH_SHORT).show();
            }}


        intent.putExtra("crt",correct);
        intent.putExtra("scr",score);
        startActivity(intent);
        Toast.makeText(getApplicationContext(),"You have " + correct + "Correct Answers",Toast.LENGTH_LONG).show();
        startActivity(intent);

    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.score3);
        quantityTextView.setText("" + number);
    }
    /**
     *Disable back button
     * Calls up pop up box instead
     */
    @Override
    public void onBackPressed() {
        Button txtclose;
        Button menu;
        Button close;
        myDialog.setContentView(R.layout.activity_main11);
        txtclose =(Button) myDialog.findViewById(R.id.closs);
        menu = (Button) myDialog.findViewById(R.id.main_menu);
        close = (Button) myDialog.findViewById(R.id.quit);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.finishAffinity(Main5Activity.this);
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}
