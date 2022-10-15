package com.example.babyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class foodpage extends AppCompatActivity {
    public  ProgressBar baby_hungerBar;
    public  ImageButton babyfood_pbutton, babymilk_pbutton,home;
    public  int babyfood_pcount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodpage);
        hungerprogress();
        homewindow();

    }
    public void hungerprogress(){
        babyfood_pbutton = (ImageButton) findViewById(R.id.babyfoodbutton);



        babyfood_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (babyfood_pcount < 100) {
                    babyfood_pcount = 50;


                }
            }
        });
    }
    public void homewindow(){
        home=(ImageButton) findViewById(R.id.homebutton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(foodpage.this,HomeScreen.class);
                startActivity(intent);
            }
        });
    }


}