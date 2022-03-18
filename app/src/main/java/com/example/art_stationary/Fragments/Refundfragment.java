package com.example.art_stationary.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.art_stationary.R;


public class Refundfragment extends Fragment {
    TextView textView;

    public Refundfragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_refundfragment, container, false);
        textView = view.findViewById(R.id.toolheadtext);
        textView.setText("Refund policy");
        return view;
    }
}