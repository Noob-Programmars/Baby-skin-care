package com.example.babyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.text.NoCopySpan;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class Slide_layout extends AppCompatActivity {
    ViewPager mslideViewPager;
    LinearLayout mDotlayer;
    SliderAdapter sliderAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_layout);
        mslideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotlayer = (LinearLayout) findViewById(R.id.dotslayer);
        sliderAdapter = new SliderAdapter(this);
        mslideViewPager.setAdapter(sliderAdapter);
    }
}