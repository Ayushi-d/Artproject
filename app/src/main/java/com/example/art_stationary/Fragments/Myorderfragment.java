
package com.example.art_stationary.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.art_stationary.Adapter.Gridhomeadapter;
import com.example.art_stationary.Adapter.Mycartadapter;
import com.example.art_stationary.Adapter.Myorderadapter;
import com.example.art_stationary.Model.Cartmodel;
import com.example.art_stationary.Model.Myordermodel;
import com.example.art_stationary.R;

import java.util.ArrayList;


public class Myorderfragment extends Fragment {
    RecyclerView Myorderslist;
    private ArrayList<Myordermodel> myordermodelArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_myorderfragment, container, false);
        Myorderslist = view.findViewById(R.id.Myorderslist);

        myordermodelArrayList=new ArrayList<>();

        myordermodelArrayList.add(new Myordermodel("12333","13234","222022","Approved"));
        myordermodelArrayList.add(new Myordermodel("12333","13234","222022","Pending"));
        Myorderadapter myorderadapter=new Myorderadapter(myordermodelArrayList,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        Myorderslist.setLayoutManager(linearLayoutManager);
        myorderadapter.setOnItemClickListener(new Gridhomeadapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.flFragment, new OrdernoFragment(), "NewFragmentTag");
                ft.commit();
                ft.addToBackStack(null);
            }
        });
        Myorderslist.setAdapter(myorderadapter);

        return view;
    }
}