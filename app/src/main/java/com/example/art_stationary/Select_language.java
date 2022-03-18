package com.example.art_stationary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Select_language extends AppCompatActivity {

     ImageView iconeng;
     ImageView iconurdu;
     TextView textenglishh;
     TextView texturdu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        iconurdu = findViewById(R.id.iconurdu);
        iconeng = findViewById(R.id.iconeng);
        textenglishh = findViewById(R.id.textenglishh);
        texturdu = findViewById(R.id.texturdu);

        textenglishh.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                iconeng.setVisibility(View.VISIBLE);
                iconurdu.setVisibility(View.GONE);
                Intent send = new Intent(Select_language.this, Navigate_dots.class);
                startActivity(send);

            }
        });

        texturdu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                iconurdu.setVisibility(View.VISIBLE);
                iconeng.setVisibility(View.GONE);
                Intent send = new Intent(Select_language.this, Navigate_dots.class);
                startActivity(send);
            }
        });

    }
}