package com.example.art_stationary.Fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.art_stationary.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class CheckoutFragment extends Fragment implements AdapterView.OnItemSelectedListener {
     TextView txt_edit;
     ConstraintLayout card_alladdress;
     Button button_paynow;
    ConstraintLayout toolbar;
    TextView tooltext;
    BottomNavigationView navBar;


    Spinner timespinner;

    String[] time = { "Evening 4:00 - 5:00 PM", "Evening 4:00 - 5:00 PM",
            "Evening 4:00 - 5:00 PM", "Evening 4:00 - 5:00 PM",
            "Evening 4:00 - 5:00 PM", "Evening 4:00 - 5:00 PM" };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_checkout, container, false);
        txt_edit=view.findViewById(R.id.txt_edit);
        card_alladdress=view.findViewById(R.id.card_alladdress);
        button_paynow=view.findViewById(R.id.button_paynow);
        toolbar = view.findViewById(R.id.toolbar);
        tooltext = toolbar.findViewById(R.id.toolheadtext);
        tooltext.setText("Checkout");

        navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.GONE);

        Spinner spino = view.findViewById(R.id.timespinner);
        spino.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getActivity());

        ArrayAdapter ad
                = new ArrayAdapter(
                getActivity(),
                android.R.layout.simple_spinner_item,
                time);
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        spino.setAdapter(ad);

        txt_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.flFragment, new AddressFragment(), "NewFragmentTag");
                ft.commit();
                ft.addToBackStack(null);
            }
        });
        button_paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.flFragment, new ThankyouFragment(), "NewFragmentTag");
                ft.commit();
                ft.addToBackStack(null);
            }
        });
        card_alladdress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.flFragment, new SavedAddressFragment(), "NewFragmentTag");
                ft.commit();
                ft.addToBackStack(null);
            }
        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
       /* Toast.makeText(getActivity(),
                time[position],
                Toast.LENGTH_LONG)
                .show();*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}