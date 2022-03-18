package com.example.art_stationary;

import android.app.Application;
import android.content.Context;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Global extends Application {

    public static Global instance;
    public BottomNavigationView navBar;

    public void onCreate() {
        super.onCreate();
        instance = new Global();

    }

    public void showhidebottomNav(View v, Boolean isshow){
        if (isshow==true){
            //navBar.setVisibility(View.VISIBLE);
        }else{
            //navBar.setVisibility(View.GONE);
        }
    }

}
