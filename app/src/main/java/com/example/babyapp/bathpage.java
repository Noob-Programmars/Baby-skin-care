package com.example.babyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class bathpage extends AppCompatActivity {
    ImageButton home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathpage);
        homewindow();
    }
    public void homewindow(){
        home=(ImageButton) findViewById(R.id.homebutton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bathpage.this,HomeScreen.class);
                startActivity(intent);
            }
        });

    }




}