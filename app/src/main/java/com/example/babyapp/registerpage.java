package com.example.babyapp;

import static com.example.babyapp.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registerpage extends AppCompatActivity {
    Button createacc;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_registerpage);
        createacc = (Button) findViewById(id.createacc);
        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registerpage.this, HomeScreen.class);
                startActivity(intent);
            }
        });
    }
}