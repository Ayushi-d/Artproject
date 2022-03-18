package com.example.art_stationary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.art_stationary.Activity.ForgotPassword;
import com.example.art_stationary.Activity.MainActivity;

public class Singin extends AppCompatActivity {
    TextView txt_donthaveacc;
    TextView text_forgotpass;
    TextView button_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        txt_donthaveacc = findViewById(R.id.txt_donthaveacc);
        text_forgotpass = findViewById(R.id.text_forgotpass);
        button_signin = findViewById(R.id.button_signin);

        txt_donthaveacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent noaccintent = new Intent(getApplicationContext(), Signup.class);
                startActivity(noaccintent);
            }
        });
        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent singinintent = new Intent(Singin.this, MainActivity.class);
                startActivity(singinintent);
            }
        });
        text_forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgotintent = new Intent(Singin.this, ForgotPassword.class);
                startActivity(forgotintent);
            }
        });
    }
}