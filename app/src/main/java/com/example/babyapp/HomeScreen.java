package com.example.babyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
public class HomeScreen extends AppCompatActivity{
     Dialog mydialog;
     public  int diaper_pcount = 0, hunger_pcount = 0, cribsheets_pcount = 0, cribcond_pcount = 0, balance = 100;
     public ProgressBar diaper_pBar, hunger_pbar, cribsheets_pBar, cribcond_pBar;
     public Button diaper_pbutton, hunger_pbutton, cribsheets_pbutton, cribcond_pbutton;
     TextView txtclose;
     public static WeakReference<HomeScreen> weakActivity;
     Boolean  bit7=false, bit8=false, bit9=false, bit10=false,bit11=false;
     public  ImageButton shopbutton, bathbutton, foodbutton,menubutton;
     public ImageView drawerimg,cirbimg,alertimg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mydialog = new Dialog(this);
        new Timer().schedule(task, 0, 1000);
        drawerimg =(ImageView) findViewById(R.id.drawerimageview);
        alertimg =(ImageView) findViewById(R.id.warningimg);
        weakActivity = new WeakReference<>(HomeScreen.this);
        menubutton();
        cartbutton();
        bathwindow();
        foodwindow();
    }
    public static HomeScreen getmInstanceActivity(){
        return weakActivity.get();
    }
    public void menubutton(){
        menubutton = findViewById(R.id.menubutton);
        menubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,menuactivity.class);
                startActivity(intent);
            }
        });
    }
    public void infopopup(View v){
        mydialog.setContentView(R.layout.infolayout);
        txtclose = (TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void Showpopup(View v) {

        mydialog.setContentView(R.layout.babypopup);
        txtclose = (TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        babyprogress();
        mydialog.show();
    }

    public void Showpopup2(View v) {
        mydialog.setContentView(R.layout.cribpopup);
        txtclose = (TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        cribprogress();
        mydialog.show();
    }
    public void showpopup3(View v){
        mydialog.setContentView(R.layout.alertlayout);
        txtclose = (TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }

    public void babyprogress() {
        diaper_pBar = (ProgressBar) mydialog.findViewById(R.id.diaperprogressBar);
        diaper_pbutton = (Button) mydialog.findViewById(R.id.changediapers);
        diaper_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (diaper_pcount < 100) {
                    diaper_pcount = 100;
                }

            }
        });
    }

    public void cribprogress() {
        cribcond_pBar = (ProgressBar) mydialog.findViewById(R.id.cribcleaninessprogressbar);
        cribcond_pbutton = (Button) mydialog.findViewById(R.id.cleancrib);
        cribcond_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cribcond_pcount < 100) {
                    cribcond_pcount = 100;
                }
            }
        });
        cribsheets_pBar = (ProgressBar) mydialog.findViewById(R.id.cribsheetsprogressBar);
        cribsheets_pbutton = (Button) mydialog.findViewById(R.id.changesheets);
        cribsheets_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cribsheets_pcount < 100) {
                    cribsheets_pcount = 100;
                }
            }
        });
    }


    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            if(diaper_pcount>0){
                diaper_pcount--;
                diaper_pBar.setProgress(diaper_pcount);
                diaper_pBar.setMax(100);
            }
            if(hunger_pcount>0){
                hunger_pcount--;
                hunger_pbar.setProgress(hunger_pcount);
                hunger_pbar.setMax(100);
            }
            if(cribcond_pcount>0){
                cribcond_pcount--;
                cribcond_pBar.setProgress(cribcond_pcount);
                cribcond_pBar.setMax(100);
            }
            if(cribsheets_pcount>0){
                cribsheets_pcount--;
                cribsheets_pBar.setProgress(cribsheets_pcount);
                cribsheets_pBar.setMax(100);
            }
            if(diaper_pcount ==0 || hunger_pcount==0 || cribcond_pcount==0 || cribsheets_pcount==0){
                  alertimg.setImageResource(R.drawable.warningsign);
            }
            if(diaper_pcount >0 && hunger_pcount>0 && cribcond_pcount>0 && cribsheets_pcount>0){
                alertimg.setImageResource(0);
            }

        }
    };


    public void cartbutton(){
        shopbutton=(ImageButton) findViewById(R.id.cartbutton);
        shopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this,storeactivity.class);
                startActivity(intent);
            }
        });
    }
    public void bathwindow(){
        bathbutton=(ImageButton) findViewById(R.id.bathbutton);
        bathbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this,bathpage.class);
                startActivity(intent);
            }
        });

    }
    public void foodwindow(){
        foodbutton=(ImageButton) findViewById(R.id.foodbutton);
        foodbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this,foodpage.class);
                startActivity(intent);
            }
        });
    }
    public void setdrawer(){
        drawerimg.setImageResource(R.drawable.drawer2);
    }

}
