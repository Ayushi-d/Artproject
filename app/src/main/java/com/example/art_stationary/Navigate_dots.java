package com.example.art_stationary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.art_stationary.Adapter.Mostpopularadapter;
import com.example.art_stationary.Adapter.Pageradapter;
import com.example.art_stationary.Model.IntroModel;
import com.example.art_stationary.Model.Mostpopularmodel;
import com.example.art_stationary.Model.Recyclerhomemodel;
import com.google.android.material.progressindicator.LinearProgressIndicator;

import java.util.ArrayList;

public class Navigate_dots extends AppCompatActivity {
    RecyclerView banner_view;
    Button btn_next;
    private ArrayList<IntroModel> recylerIntroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate_dots);
        banner_view = findViewById(R.id.banner_view);
        btn_next = findViewById(R.id.btn_next);

        recylerIntroList = new ArrayList<>();
        recylerIntroList.add(new IntroModel("Quickly","Donec sodales, ex a vulputate varius, nisi enim maximus ante, a placerat enim sem id.",R.drawable.navigationbookicon));
        recylerIntroList.add(new IntroModel("Safely","Donec sodales, ex a vulputate varius, nisi enim maximus ante, a placerat enim sem id.",R.drawable.navigationbookicon));
        recylerIntroList.add(new IntroModel("Easy","Donec sodales, ex a vulputate varius, nisi enim maximus ante, a placerat enim sem id.",R.drawable.navigationbookicon));
        Pageradapter pageradapter =new Pageradapter(recylerIntroList,this);
        LinearLayoutManager mostpopularmanager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(banner_view);
        banner_view.addItemDecoration(new LinePagerIndicatorDecoration());
        banner_view.setLayoutManager(mostpopularmanager);
        banner_view.setAdapter(pageradapter);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(Navigate_dots.this, Singin.class);
                startActivity(send);
            }
        });

    }

}