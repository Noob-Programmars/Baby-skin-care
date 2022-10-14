package com.example.babyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;


public class MainActivity extends AppCompatActivity {
    Button signin;
    Button register;
    EditText email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signin=(Button) findViewById(R.id.signin);
        email=(EditText) findViewById(R.id.lpemail);
        password=(EditText) findViewById(R.id.lppassword);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HomeScreen.class);
                startActivity(intent);
            }
        });
        register=(Button) findViewById(R.id.create);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,registerpage.class);
                startActivity(intent);
            }
        });

    }
}