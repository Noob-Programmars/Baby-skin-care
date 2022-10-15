package com.example.babyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class storeactivity extends AppCompatActivity {
    Button it1, it2, it3, it4, it5, it6, it7, it8, it9, it10,it11;
    int milkcount, foodcount, medicinecount, soapcount, shampoocount, spongecount, balance=100;
    Boolean  bit7=false, bit8=false, bit9=false, bit10=false,bit11=false;
    ImageButton home;
    TextView txtclose;
    Dialog mydialog;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storeactivity);
        it1 = findViewById(R.id.storemilkbutton);
        it2 = findViewById(R.id.storfoodbutton);
        it3 = findViewById(R.id.storemedicinebutton);
        it4 = findViewById(R.id.storeshampoobutton);
        it5 = findViewById(R.id.storesoapbutton);
        it6 = findViewById(R.id.storespongebutton);
        it7 = findViewById(R.id.storetoysbutton);
        it8 = findViewById(R.id.storebluedrawerbutton);
        it9 = findViewById(R.id.storedefaultdrawerbutton);
        it10 = findViewById(R.id.storecribwithtoybutton);
        it11 = findViewById(R.id.storemoderncribbutton);
        button();
        mydialog = new Dialog(this);
        homewindow();

    }
    public void button(){
        it1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(balance>=25){
                    milkcount++;
                    balance = balance-25;
                    HomeScreen.getmInstanceActivity().setimg(5);
                }
            }
        });
        it2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(balance>=25){
                    foodcount++;

                    HomeScreen.getmInstanceActivity().setimg(6);
                }
            }
        });
        it3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(balance>=25){
                    medicinecount++;

                    HomeScreen.getmInstanceActivity().setimg(7);
                }
            }
        });
        it4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(balance>=25){
                    shampoocount++;

                    HomeScreen.getmInstanceActivity().setimg(8);
                }
            }
        });
        it5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(balance>=25){
                    soapcount++;

                    HomeScreen.getmInstanceActivity().setimg(9);
                }
            }
        });
        it6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(balance>=25){
                    spongecount++;

                    HomeScreen.getmInstanceActivity().setimg(10);
                }
            }
        });
        it7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bit7 == false) {
                    if (balance >= 50) {

                        bit7 = true;
                        it7.setText("Equip");
                    }
                }else{
                    HomeScreen.getmInstanceActivity().setimg(0);
                }
            }

        });
        it8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bit8 == false) {
                    if (balance >= 50) {

                        bit8 = true;
                        it8.setText("Equip");
                    }
                }else{
                    HomeScreen.getmInstanceActivity().setimg(1);
                }

            }
        });
        it9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bit9 == false) {
                    if (balance >= 50) {

                        bit9 = true;
                        it9.setText("Equip");
                    }
                }else{
                    HomeScreen.getmInstanceActivity().setimg(2);
                }

            }
        });
        it10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bit10 == false) {
                    if (balance >= 50) {

                        bit10 = true;
                        it10.setText("Equip");
                    }
                }else{
                    HomeScreen.getmInstanceActivity().setimg(3);
                }

            }
        });
        it11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bit11 == false) {
                    if (balance >= 50) {

                        bit11 = true;
                        it11.setText("Equip");
                    }
                }else{
                    HomeScreen.getmInstanceActivity().setimg(4);
                }
            }
        });

    }
    public void homewindow(){
        home=(ImageButton) findViewById(R.id.homebutton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(storeactivity.this,HomeScreen.class);
                startActivity(intent);
            }
        });
    }
    public void milkinfopopup(View view){
        mydialog.setContentView(R.layout.milkinfopopup);
        txtclose = (TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();

    }
    public void foodpopup(View view){

        mydialog.setContentView(R.layout.foodinfopopup);
        txtclose = (TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();

    }

    public void medicinepopup(View view){

        mydialog.setContentView(R.layout.medicineinfopopup);
        txtclose = (TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();

    }
    public void shampoopopup(View view){

        mydialog.setContentView(R.layout.milkinfopopup);
        txtclose = (TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();

    }
    public void soappopup(View view){

        mydialog.setContentView(R.layout.milkinfopopup);
        txtclose = (TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();

    }
    public void spongepopup(View view){

        mydialog.setContentView(R.layout.milkinfopopup);
        txtclose = (TextView) mydialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();

    }
}