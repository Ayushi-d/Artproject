package com.example.art_stationary.Fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.art_stationary.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Refundfragment extends Fragment {
    ConstraintLayout toolbar;
    TextView tooltext;
    BottomNavigationView navBar;
    TextView textView;
    ConstraintLayout img_back;


    public Refundfragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_refundfragment, container, false);
        getActivity().getWindow().setStatusBarColor(getActivity().getColor(R.color.black));
        img_back =view.findViewById(R.id.img_back);
        navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.GONE);
        toolbar = view.findViewById(R.id.toolbar);
        textView = view.findViewById(R.id.toolheadtext);
        textView.setText("Refund policy");

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        return view;
    }
}