package com.example.art_stationary.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.art_stationary.Adapter.BrandAdpter;
import com.example.art_stationary.Adapter.Gridhomeadapter;
import com.example.art_stationary.Adapter.Mostpopularadapter;
import com.example.art_stationary.Adapter.Offeradapter;
import com.example.art_stationary.Adapter.Verticalhomeadapter;
import com.example.art_stationary.Adapter.ViewPagerAdapter;
import com.example.art_stationary.Global;
import com.example.art_stationary.Model.BrandModel;
import com.example.art_stationary.Model.Mostpopularmodel;
import com.example.art_stationary.Model.Offermodel;
import com.example.art_stationary.Model.Recyclerhomemodel;
import com.example.art_stationary.Model.Verticallistmodel;
import com.example.art_stationary.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    ViewPager viewPager;
    private RecyclerView gridlist;
    private RecyclerView verticallist;
    private RecyclerView Offerslist;
    private RecyclerView mostpopularlist;

    private ArrayList<Recyclerhomemodel> recyclerDataArrayList;
    private ArrayList<BrandModel> verticalArraylist;
    private ArrayList<Offermodel> OffersArraylist;
    private ArrayList<Mostpopularmodel> mostpopularArraylist;
    public HomeFragment() {
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = view.findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.VISIBLE);
        //Global.instance.showhidebottomNav(view,true);

        gridlist = view.findViewById(R.id.gridlist);
        verticallist= view.findViewById(R.id.verticallist);
        Offerslist = view.findViewById(R.id.Offerslist);
        mostpopularlist = view.findViewById(R.id.mostpopularlist);

        // created new array list..
        recyclerDataArrayList=new ArrayList<>();
        verticalArraylist=new ArrayList<>();
        OffersArraylist=new ArrayList<>();
        mostpopularArraylist=new ArrayList<>();

        // added data to grid array list
        recyclerDataArrayList.add(new Recyclerhomemodel("Java","12.00 KWD",R.drawable.custombookimage));
        recyclerDataArrayList.add(new Recyclerhomemodel("Automation","34.66 KWD",R.drawable.custombookimage));
        recyclerDataArrayList.add(new Recyclerhomemodel("Manual","77.88 KWD",R.drawable.custombookimage));
        recyclerDataArrayList.add(new Recyclerhomemodel("Android","56.00 KWD",R.drawable.custombookimage));
        Gridhomeadapter adapter=new Gridhomeadapter(recyclerDataArrayList,getActivity());
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        gridlist.setLayoutManager(layoutManager);
        adapter.setOnItemClickListener(new Gridhomeadapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.flFragment, new ItemFragment(), "NewFragmentTag");
                ft.commit();
                ft.addToBackStack(null);
            }
        });
        gridlist.setAdapter(adapter);

        // added data to Vertical array list
        verticalArraylist.add(new BrandModel(R.drawable.custombookimage));
        verticalArraylist.add(new BrandModel(R.drawable.custombookimage));
        verticalArraylist.add(new BrandModel(R.drawable.custombookimage));
        verticalArraylist.add(new BrandModel(R.drawable.custombookimage));
        BrandAdpter verticaladapter=new BrandAdpter(verticalArraylist,getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2,RecyclerView.HORIZONTAL,false);
        verticallist.setLayoutManager(gridLayoutManager);
        verticallist.setAdapter(verticaladapter);

        // added data to Offer array list
        OffersArraylist.add(new Offermodel(R.drawable.custombookimage));
        OffersArraylist.add(new Offermodel(R.drawable.custombookimage));
        OffersArraylist.add(new Offermodel(R.drawable.custombookimage));
        OffersArraylist.add(new Offermodel(R.drawable.custombookimage));
        Offeradapter offeradapter=new Offeradapter(OffersArraylist,getActivity());
        LinearLayoutManager offermanager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        Offerslist.setLayoutManager(offermanager);
        Offerslist.setAdapter(offeradapter);

        // added data to Popular array list
        mostpopularArraylist.add(new Mostpopularmodel("Java","12.00 KWD",R.drawable.custombookimage));
        mostpopularArraylist.add(new Mostpopularmodel("Java","12.00 KWD",R.drawable.custombookimage));
        Mostpopularadapter mostpopularadapter =new Mostpopularadapter(mostpopularArraylist,getActivity());
        LinearLayoutManager mostpopularmanager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        mostpopularlist.setLayoutManager(mostpopularmanager);
        mostpopularlist.setAdapter(mostpopularadapter);
        return view;
    }
}