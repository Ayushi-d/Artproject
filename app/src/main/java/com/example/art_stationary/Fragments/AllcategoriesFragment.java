package com.example.art_stationary.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.art_stationary.Adapter.Tabcategoriesadapter;
import com.example.art_stationary.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class AllcategoriesFragment extends Fragment {
    private static final int NUM_PAGES = 3;
    public static ViewPager2 view_pager;
    public static TabLayout tab_layout;
    private Tabcategoriesadapter pagerAdapter;
    // Arrey of strings FOR TABS TITLES
    private String[] titles = new String[]{"Tab1", "Tab2", "Tab3"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_allcategories, container, false);
        view_pager = view.findViewById(R.id.view_pager);
        tab_layout= view.findViewById(R.id.tab_layout);
        tab_layout.addTab(tab_layout.newTab().setText("Ink Categories"));
        tab_layout.addTab(tab_layout.newTab().setText("Toner Categories"));
        tab_layout.addTab(tab_layout.newTab().setText("Type writer"));

        pagerAdapter = new Tabcategoriesadapter(getActivity());
        view_pager.setAdapter(pagerAdapter);


        new TabLayoutMediator(tab_layout, view_pager,(tab, position) -> tab.setText(titles[position])).attach();
        return view;
    }
}