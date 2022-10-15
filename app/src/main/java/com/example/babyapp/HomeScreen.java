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
import android.util.Log;
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
     public  int diaper_pcount = 0, hunger_pcount = 0, cribsheets_pcount = 0, cribcond_pcount = 0, balance = 100, health_pcoount=0, clean_pcount=0, milkiconcount=0 , foodiconcount = 0, medicineiconcount =0, soapiconcount=0,shampooiconcount=0,spongeiconcount=0;
     public ProgressBar diaper_pBar, hunger_pbar, cribsheets_pBar, cribcond_pBar, hunger_pbar2, health_pbar,health_pbar2, clean_pbar, clean_pbar2;
     public Button diaper_pbutton, cribsheets_pbutton, cribcond_pbutton;
     TextView txtclose, warning, balanceview;
     public static WeakReference<HomeScreen> weakActivity;
     public  ImageButton shopbutton,menubutton,hunger_pbutton1,hunger_pbutton2, health_pbutton, clean1_pbutton, clean2_pbutton, clean3_pbutton;
     public ImageView drawerimg,cirbimg,toyimg;
     public TextView milk1, food1, med1, shamp1, soap1,spong1;




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

    }
    public void foodpopup(View v) {

        mydialog.setContentView(R.layout.mainfoodllayout);

        mydialog.show();
        hungerprogress();

    }
    public void hungerprogress() {
        hunger_pbar = (ProgressBar) mydialog.findViewById(R.id.hungerprogressBar);
        health_pbar = (ProgressBar) mydialog.findViewById(R.id.healthprogressBar);
        health_pbutton = (ImageButton) mydialog.findViewById(R.id.babymedicineButton);
        hunger_pbutton1 = (ImageButton) mydialog.findViewById(R.id.babymilkButton);
        hunger_pbutton2 = (ImageButton) mydialog.findViewById(R.id.babyfoodbutton);
        med1 = (TextView) mydialog.findViewById(R.id.med1);
        food1 = (TextView) mydialog.findViewById(R.id.food1);
        milk1 = (TextView) mydialog.findViewById(R.id.milk1);
        hunger_pbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(milkiconcount>=1) {
                    if (hunger_pcount < 50) {
                        hunger_pcount = hunger_pcount + 50;
                    } else if (hunger_pcount > 50 && hunger_pcount < 100) {
                        hunger_pcount = hunger_pcount + (100 - hunger_pcount);

                    }
                    balance = balance + 25;
                    milkiconcount--;
                    milk1.setText(String.valueOf(milkiconcount));
                }

            }
        });
        hunger_pbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(foodiconcount>=1) {

                    if (hunger_pcount < 50) {
                        hunger_pcount = hunger_pcount + 50;
                    } else if (hunger_pcount > 50 && hunger_pcount < 100) {
                        hunger_pcount = hunger_pcount + (100 - hunger_pcount);

                    }
                    balance = balance + 25;
                    foodiconcount--;
                    food1.setText(String.valueOf(foodiconcount));

                }
            }
        });
        health_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(medicineiconcount>=1) {
                    if (health_pcoount < 50) {
                        health_pcoount = health_pcoount + 50;
                    } else if (health_pcoount > 50 && health_pcoount < 100) {
                        health_pcoount = health_pcoount + (100 - health_pcoount);

                    }
                    balance = balance + 25;
                    medicineiconcount--;
                    med1.setText(String.valueOf(medicineiconcount));
                }
            }
        });
    }

    public void bathlayout(View v) {
        mydialog.setContentView(R.layout.mainbathlayout);
        mydialog.show();
        bathprogress();
    }
    public void bathprogress(){
        clean_pbar = (ProgressBar) mydialog.findViewById(R.id.cleanlinessprogressBar);
        clean1_pbutton=(ImageButton) mydialog.findViewById(R.id.soapButton);
        clean2_pbutton=(ImageButton) mydialog.findViewById(R.id.shampooButton);
        clean3_pbutton=(ImageButton) mydialog.findViewById(R.id.spongeButton);
        soap1=(TextView) mydialog.findViewById(R.id.soap1);
        shamp1=(TextView) mydialog.findViewById(R.id.shamp1);
        spong1=(TextView) mydialog.findViewById(R.id.sponge1);
        clean1_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(soapiconcount>=1) {
                    if (clean_pcount < 66) {
                        clean_pcount = clean_pcount + 33;

                    } else if (clean_pcount > 66 && clean_pcount < 100) {
                        clean_pcount = clean_pcount + (100 - clean_pcount);
                    }
                    balance = balance + 25;
                    soapiconcount--;
                    soap1.setText(String.valueOf(soapiconcount));

                }

            }
        });
        clean2_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shampooiconcount >= 1) {


                    if (clean_pcount < 66) {
                        clean_pcount = clean_pcount + 33;
                    } else if (clean_pcount > 66 && clean_pcount < 100) {
                        clean_pcount = clean_pcount + (100 - clean_pcount);
                    }
                    balance = balance + 25;
                    shampooiconcount--;
                    shamp1.setText(String.valueOf(shampooiconcount));


                }
            }
        });
        clean3_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spongeiconcount >= 1) {
                    if (clean_pcount < 66) {
                        clean_pcount = clean_pcount + 33;
                    } else if (clean_pcount > 66 && clean_pcount < 100) {
                        clean_pcount = clean_pcount + (100 - clean_pcount);
                    }
                    balance = balance + 25;
                    spongeiconcount--;
                    spong1.setText(String.valueOf(spongeiconcount));

                }
            }
        });

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
        hunger_pbar2 = (ProgressBar) mydialog.findViewById(R.id.hungerprogressBar);
        health_pbar2 = (ProgressBar) mydialog.findViewById(R.id.healthprogressBar);
        clean_pbar2 = (ProgressBar) mydialog.findViewById(R.id.cleanlinessprogressBar);
        diaper_pbutton = (Button) mydialog.findViewById(R.id.changediapers);
        diaper_pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (diaper_pcount < 100) {
                    diaper_pcount = 100;
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
                hunger_pbar2.setProgress(hunger_pcount);
                hunger_pbar2.setMax(100);
                milk1.setText(String.valueOf(milkiconcount));
                food1.setText(String.valueOf(foodiconcount));
                med1.setText(String.valueOf(medicineiconcount));
            }
            if(health_pcoount>0){
                health_pcoount--;
                health_pbar.setProgress(health_pcoount);
                health_pbar.setMax(100);
                health_pbar2.setProgress(health_pcoount);
                health_pbar2.setMax(100);

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
            if(clean_pcount>0){
                clean_pcount--;
                clean_pbar.setProgress(clean_pcount);
                clean_pbar.setMax(100);
                clean_pbar2.setProgress(clean_pcount);
                clean_pbar2.setMax(100);
                soap1.setText(String.valueOf(soapiconcount));
                shamp1.setText(String.valueOf(shampooiconcount));
                spong1.setText(String.valueOf(spongeiconcount));
            }
            if(diaper_pcount==10) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder( HomeScreen.this,"My Notification");
                builder.setContentTitle("Your baby needs you!");
                builder.setContentText("time to care for the baby");
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



    public void setimg(int i) {
        if(i==0){
            if(balance>50){
            toyimg.setImageResource(R.drawable.toys);
            balance = balance -50;}
        }else if (i == 1) {
            if(balance>50){
            drawerimg.setImageResource(R.drawable.drawer2);
            balance = balance -50;}
        }else if(i==2){
            if(balance>50){
            drawerimg.setImageResource(R.drawable.drawer3);
            balance = balance -50;}
        }else if(i==3){
            if(balance>50){
            cirbimg.setImageResource(R.drawable.crib2);
            balance = balance -50;}
        }else if(i==4){
            if(balance>50){
            cirbimg.setImageResource(R.drawable.crib3);
            balance = balance -50;}
        }else if(i==5){
            if(balance>25){
            milkiconcount++;
            balance = balance -25;}
        } else if(i==6){
            if(balance>25){
            foodiconcount++;
            balance = balance -25;}
        }else if(i==7){
            if(balance>25){
            medicineiconcount++;
            balance = balance -25;}
        }else if(i==8){if(balance>25){
            shampooiconcount++;
            balance = balance -25;}
        }else if(i==9){
            if(balance>25){
            soapiconcount++;
            balance = balance -25;}
        }else if(i==10){
            if(balance>25){
            spongeiconcount++;
            balance = balance -25;}
        }
    }

}
