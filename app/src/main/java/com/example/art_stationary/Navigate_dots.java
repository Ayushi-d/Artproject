package com.example.art_stationary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.progressindicator.LinearProgressIndicator;

public class Navigate_dots extends AppCompatActivity {
    LinearProgressIndicator indicator_view;
    ViewPager banner_view;
    Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate_dots);
        indicator_view = findViewById(R.id.indicator_view);
        banner_view = findViewById(R.id.banner_view);
        btn_next = findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(Navigate_dots.this, Singin.class);
                startActivity(send);
            }
        });

    }
}