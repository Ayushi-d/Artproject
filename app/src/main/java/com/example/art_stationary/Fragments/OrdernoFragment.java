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
import com.example.art_stationary.Adapter.Ordernoadapter;
import com.example.art_stationary.Model.Cartmodel;
import com.example.art_stationary.Model.OrdernoModel;
import com.example.art_stationary.R;

import java.util.ArrayList;


public class OrdernoFragment extends Fragment {
    RecyclerView recyclerorderno;
    private ArrayList<OrdernoModel> ordernoarraylist;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_orderno, container, false);
        recyclerorderno=view.findViewById(R.id.recyclerorderno);
        ordernoarraylist=new ArrayList<>();

        ordernoarraylist.add(new OrdernoModel("Abc","243535","3",R.drawable.custombookimage));
        ordernoarraylist.add(new OrdernoModel("Abc","243535","3",R.drawable.custombookimage));
        ordernoarraylist.add(new OrdernoModel("Abc","243535","3",R.drawable.custombookimage));
        ordernoarraylist.add(new OrdernoModel("Abc","243535","3",R.drawable.custombookimage));
        Ordernoadapter ordernoadapter=new Ordernoadapter(ordernoarraylist,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerorderno.setLayoutManager(linearLayoutManager);
        recyclerorderno.setAdapter(ordernoadapter);
        return view;
    }
}