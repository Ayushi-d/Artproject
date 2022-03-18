package com.example.art_stationary.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.art_stationary.R;

public class Tearmsandcondition extends Fragment {
   TextView textView;
    public Tearmsandcondition() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.fragment_tearmsandcondition, container, false);
        textView = view.findViewById(R.id.toolheadtext);
        textView.setText("Tearms and Condition");
        return view;

    }
}