package com.example.art_stationary.Fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.art_stationary.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class AddressFragment extends Fragment {
    ConstraintLayout toolbar;
    TextView tooltext;
    BottomNavigationView navBar;

    public AddressFragment() {
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
        View view= inflater.inflate(R.layout.fragment_address, container, false);
        toolbar = view.findViewById(R.id.toolbar);
        tooltext = toolbar.findViewById(R.id.toolheadtext);
        tooltext.setText("Address");

        navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.GONE);

        return view;
    }
}