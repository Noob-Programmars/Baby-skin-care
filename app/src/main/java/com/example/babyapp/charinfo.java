package com.example.babyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class charinfo extends AppCompatActivity {
    Button finish;
    ImageButton male,female;
    Boolean gender; //male- true female-false
    ImageView maleimg, femaleimg;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charinfo);
        finish=(Button) findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(charinfo.this,Slide_layout.class);
                startActivity(intent);
            }
        });
        male = (ImageButton) findViewById(R.id.malebutton);
        female = (ImageButton) findViewById(R.id.femalebutton);
        maleimg = (ImageView) findViewById(R.id.maleimg);
        femaleimg = (ImageView) findViewById(R.id.femaleimg);
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = true;
                if(gender==true){
                    maleimg.setImageResource(R.drawable.maleon);
                    femaleimg.setImageResource(R.drawable.femaleicon);
                }
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = false;
                if(gender==false){
                    maleimg.setImageResource(R.drawable.maleicon);
                    femaleimg.setImageResource(R.drawable.femaleon);
                }
            }
        });


    }
}