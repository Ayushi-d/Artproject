package com.example.art_stationary.Fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.art_stationary.Adapter.Colorhomeadapter;
import com.example.art_stationary.Adapter.Gridhomeadapter;
import com.example.art_stationary.Global;
import com.example.art_stationary.Model.Colormodel;
import com.example.art_stationary.Model.Recyclerhomemodel;
import com.example.art_stationary.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ItemFragment extends Fragment {
    ConstraintLayout constraintLayout;
    ImageView img_back;
    RecyclerView listcolor;
    Button button_addtocart;
    TextView textmedium,textsmall,textlarge,textxl;
    private ArrayList<Colormodel> recyclercolorarraylist;

    public ItemFragment() {
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
        View view= inflater.inflate(R.layout.fragment_item, container, false);
        constraintLayout = view.findViewById(R.id.constraintLayout);
        img_back = view.findViewById(R.id.img_back);
        textmedium = view.findViewById(R.id.textmedium);
        textsmall = view.findViewById(R.id.textsmall);
        textlarge = view.findViewById(R.id.textlarge);
        textxl = view.findViewById(R.id.textxl);
        listcolor = view.findViewById(R.id.listcolor);
        button_addtocart = view.findViewById(R.id.button_addtocart);
       /* if (textsmall.isSelected()){
            textsmall.setBackground(R.drawable.sizebackground);
            textsmall.setTextColor(R.color.white);
        }else if (textmedium.isSelected())
        }*/

        button_addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.flFragment, new CartFragment(), "NewFragmentTag");
                ft.commit();
                ft.addToBackStack(null);
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.flFragment, new HomeFragment(), "NewFragmentTag");
                ft.commit();
                ft.addToBackStack(null);
            }
        });

        recyclercolorarraylist = new ArrayList<>();

        // added data to grid array list
        recyclercolorarraylist.add(new Colormodel(R.color.grey));
        recyclercolorarraylist.add(new Colormodel(R.color.grey));
        Colorhomeadapter adapter = new Colorhomeadapter(recyclercolorarraylist, getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        listcolor.setLayoutManager(layoutManager);
        listcolor.setAdapter(adapter);

        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.GONE);
        return view;
    }
}