package com.example.babyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class storeactivity extends AppCompatActivity {
    Button it1, it2, it3, it4, it5, it6, it7, it8, it9, it10,it11;
    int milkcount, foodcount, medicinecount, soapcount, shampoocount, spongecount, balance=100;
    Boolean  bit7=false, bit8=false, bit9=false, bit10=false,bit11=false;
    HomeScreen hs = new HomeScreen();

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
        it8 = findViewById(R.id.storedrawer2button);
        it9 = findViewById(R.id.storedrawer3button);
        it10 = findViewById(R.id.storecrib2button);
        it11 = findViewById(R.id.storecrib3button);
        button();


    }
    public void button(){
        it1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(balance>=25){
                    milkcount++;
                    balance = balance-25;
                }
            }
        });
        it2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(balance>=25){
                    foodcount++;
                    balance = balance-25;
                }
            }
        });
        it3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(balance>=25){
                    medicinecount++;
                    balance = balance-25;
                }
            }
        });
        it4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(balance>=25){
                    shampoocount++;
                    balance = balance-25;
                }
            }
        });
        it5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(balance>=25){
                    soapcount++;
                    balance = balance-25;
                }
            }
        });
        it6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(balance>=25){
                    spongecount++;
                    balance = balance-25;
                }
            }
        });
        it7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bit7 == false) {
                    if (balance >= 50) {
                        balance = balance - 50;
                        bit7 = true;
                        it7.setText("Equip");
                    }
                }else{
                    HomeScreen.getmInstanceActivity().setdrawer();
                }
            }

        });
        it8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        it9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        it10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        it11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}