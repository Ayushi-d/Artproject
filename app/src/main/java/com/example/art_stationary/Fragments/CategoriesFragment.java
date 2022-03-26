package com.example.art_stationary.Fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.art_stationary.Adapter.ExpandAdapter;
import com.example.art_stationary.Model.ExpandedCategroryModel;
import com.example.art_stationary.Model.ParentCategoryModel;
import com.example.art_stationary.Model.SubCatModel;
import com.example.art_stationary.Model.SubCategoryModel;
import com.example.art_stationary.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CategoriesFragment extends Fragment {

    ConstraintLayout toolbar;
    TextView tooltext;
    BottomNavigationView navBar;
    ConstraintLayout img_back;
    RecyclerView categoryRecyler;

    private ArrayList<ParentCategoryModel> expandedCategroryModelArrayList;
    private ArrayList<SubCatModel> subCategoryModels;
    private ArrayList<SubCatModel> subCategoryModels1;
    private ArrayList<SubCatModel> subCategoryModels2;
    private static String[] parentCategoryArray;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_categories, container, false);
        getActivity().getWindow().setStatusBarColor(getActivity().getColor(R.color.black));
        img_back =view.findViewById(R.id.img_back);
        navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.VISIBLE);
        toolbar = view.findViewById(R.id.toolbar);
        tooltext = toolbar.findViewById(R.id.toolheadtext);
        tooltext.setText("Categories");
        categoryRecyler = view.findViewById(R.id.categoryRecyler);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });


        expandedCategroryModelArrayList = new ArrayList<>();
        subCategoryModels = new ArrayList<>();
        subCategoryModels1 = new ArrayList<>();
        subCategoryModels2 = new ArrayList<>();

        subCategoryModels.add(0, new SubCatModel("onecat"));
        subCategoryModels.add(0, new SubCatModel("onecat"));
        subCategoryModels.add(0, new SubCatModel("onecat"));

        subCategoryModels1.add(0, new SubCatModel("twocat"));
        subCategoryModels1.add(0, new SubCatModel("twocat"));
        subCategoryModels1.add(0, new SubCatModel("twocat"));

        subCategoryModels2.add(0, new SubCatModel("threecat"));
        subCategoryModels2.add(0, new SubCatModel("threecat"));
        subCategoryModels2.add(0, new SubCatModel("threecat"));

        parentCategoryArray = new String[]{"one","two","three"};

        expandedCategroryModelArrayList.add(new ParentCategoryModel(parentCategoryArray[0],0,subCategoryModels,false));
        expandedCategroryModelArrayList.add(new ParentCategoryModel(parentCategoryArray[1],0,subCategoryModels1,false));
        expandedCategroryModelArrayList.add(new ParentCategoryModel(parentCategoryArray[2],0,subCategoryModels2,false));

          ExpandAdapter adapter = new ExpandAdapter(getActivity(),expandedCategroryModelArrayList);
          LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
          categoryRecyler.setLayoutManager(layoutManager);
          categoryRecyler.setAdapter(adapter);

           adapter.notifyDataSetChanged();
        return view;
    }
}