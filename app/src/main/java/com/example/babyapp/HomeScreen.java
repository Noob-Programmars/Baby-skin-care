package com.example.babyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
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
     TextView txtclose, warning, balanceview;
     public static WeakReference<HomeScreen> weakActivity;
     public  ImageButton shopbutton, bathbutton, foodbutton,menubutton;
     public ImageView drawerimg,cirbimg,toyimg;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mydialog = new Dialog(this);
        new Timer().schedule(task, 0, 1000);
        drawerimg =(ImageView) findViewById(R.id.drawerimageview);
        cirbimg = (ImageView) findViewById(R.id.cribview);
        balanceview = (TextView) findViewById(R.id.scoreview);
        warning =(TextView) findViewById(R.id.warningtext);
        toyimg = (ImageView) findViewById(R.id.toyview);
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        MediaPlayer player = MediaPlayer.create(this,R.raw.babyappsound);
        player.setLooping(true);
        player.start();


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
    public void setvalue(){
        hunger_pcount= 50;
    }
    public void infopopup(View v){
        mydialog.setContentView(R.layout.babypopupinfo);
        txtclose = (TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void cribinfopopup(View v){
        mydialog.setContentView(R.layout.cribpopupinfo);
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
                    diaper_pcount = 15;
                    balance = balance +25;
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
                    balance = balance +25;
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
                    balance = balance +25;
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
            if(diaper_pcount==1) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder( HomeScreen.this,"My Notification");
                builder.setContentTitle("Your baby needs you!");
                builder.setContentText("time to change the baby's diaper");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(HomeScreen.this);
                managerCompat.notify(1,builder.build());
                warning.setText("!");
            }
            if(diaper_pcount >10 ){
                warning.setText("");
            }

            balanceview.setText(String.valueOf(balance));

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
    public void setimg(int i) {
        if(i==0){
            toyimg.setImageResource(R.drawable.toys);
            balance = balance -50;
        }else if (i == 1) {
            drawerimg.setImageResource(R.drawable.drawer2);
            balance = balance -50;
        }else if(i==2){
            drawerimg.setImageResource(R.drawable.drawer3);
            balance = balance -50;
        }else if(i==3){
            cirbimg.setImageResource(R.drawable.crib2);
            balance = balance -50;
        }else if(i==4){
            cirbimg.setImageResource(R.drawable.crib3);
            balance = balance -50;
        }else if(i==5){
            balance = balance -25;
        }
    }

}
