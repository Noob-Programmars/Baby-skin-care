package com.example.babyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class menuactivity extends AppCompatActivity {
    Button login,quiz;
    ImageButton home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuactivity);
        loginwindow();
        quizwindow();
        homewindow();
    }
    public void loginwindow(){
        login=(Button) findViewById(R.id.button3);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuactivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }
    public void quizwindow(){
        quiz=(Button) findViewById(R.id.quizbutton);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuactivity.this,quizactivity.class);
                startActivity(intent);
            }
        });
    }
    public void homewindow(){
        home=(ImageButton) findViewById(R.id.homebutton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuactivity.this,HomeScreen.class);
                startActivity(intent);
            }
        });

    }

}