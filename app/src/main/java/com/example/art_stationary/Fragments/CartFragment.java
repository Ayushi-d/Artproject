package com.example.art_stationary.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.art_stationary.Adapter.Mycartadapter;
import com.example.art_stationary.Adapter.Verticalhomeadapter;
import com.example.art_stationary.Model.Cartmodel;
import com.example.art_stationary.Model.Recyclerhomemodel;
import com.example.art_stationary.Model.Verticallistmodel;
import com.example.art_stationary.R;

import java.util.ArrayList;


public class CartFragment extends Fragment {
     RecyclerView cartlist;
    private ArrayList<Cartmodel> cartmodelArrayList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cart, container, false);
        cartlist = view.findViewById(R.id.cartlist);
        cartmodelArrayList=new ArrayList<>();

        cartmodelArrayList.add(new Cartmodel("Abc","243535",R.drawable.custombookimage));
        cartmodelArrayList.add(new Cartmodel("Abc","243535",R.drawable.custombookimage));
        cartmodelArrayList.add(new Cartmodel("Abc","243535",R.drawable.custombookimage));
        cartmodelArrayList.add(new Cartmodel("Abc","243535",R.drawable.custombookimage));
        cartmodelArrayList.add(new Cartmodel("Abc","243535",R.drawable.custombookimage));
        cartmodelArrayList.add(new Cartmodel("Abc","243535",R.drawable.custombookimage));
        cartmodelArrayList.add(new Cartmodel("Abc","243535",R.drawable.custombookimage));

        Mycartadapter mycartadapter=new Mycartadapter(cartmodelArrayList,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

        cartlist.setLayoutManager(linearLayoutManager);
        cartlist.setAdapter(mycartadapter);

        return view;
    }
}