package com.example.art_stationary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Signup extends AppCompatActivity {

     TextView text_donthaveacc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        text_donthaveacc.findViewById(R.id.text_donthaveacc);
        text_donthaveacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(Signup.this, Signup.class);
                startActivity(send);
            }
        });
    }
}