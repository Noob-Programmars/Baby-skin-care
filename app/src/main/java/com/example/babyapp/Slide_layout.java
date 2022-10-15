package com.example.babyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.text.NoCopySpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class Slide_layout extends AppCompatActivity {
    ViewPager mslideViewPager;
    LinearLayout mDotlayer;
    SliderAdapter sliderAdapter;
    Button skip;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_layout);
        mslideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        sliderAdapter = new SliderAdapter(this);
        mslideViewPager.setAdapter(sliderAdapter);
        skip =(Button) findViewById(R.id.skipbutton);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Slide_layout.this,HomeScreen.class);
                startActivity(intent);
            }
        });
    }
}