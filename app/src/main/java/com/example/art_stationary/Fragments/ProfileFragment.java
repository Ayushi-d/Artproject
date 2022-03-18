package com.example.art_stationary.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.art_stationary.Activity.MainActivity;
import com.example.art_stationary.R;
import com.example.art_stationary.Singin;


public class ProfileFragment extends Fragment {
    TextView texttearmsandcondition;
    TextView textprivacypolicy;
    TextView textrefundpolicy;
    TextView textchangepassword;
    TextView textmyorder;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        texttearmsandcondition =  view.findViewById(R.id.texttearmsandcondition);
        textprivacypolicy = view.findViewById(R.id.textprivacypolicy);
        textrefundpolicy = view.findViewById(R.id.textrefundpolicy);
        textchangepassword = view.findViewById(R.id.textchangepassword);
        textmyorder = view.findViewById(R.id.textmyorder);


        texttearmsandcondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tearmsandcondition tearmsandcondition = new Tearmsandcondition();
                replaceFr(tearmsandcondition);
            }
        });

        textprivacypolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrivacypolicyFragment privacypolicyFragment = new PrivacypolicyFragment();
                replaceFr(privacypolicyFragment);
            }
        });

        textrefundpolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Refundfragment refundfragment = new Refundfragment();
                replaceFr(refundfragment);
            }
        });

        textchangepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangePasswordFragment changePasswordFragment = new ChangePasswordFragment();
                replaceFr(changePasswordFragment);
            }
        });

        textmyorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Myorderfragment myorderfragment = new Myorderfragment();
                replaceFr(myorderfragment);
            }
        });

        return view;
    }

    public void replaceFr(Fragment fragment){
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.flFragment, fragment, "NewFragmentTag");
        ft.commit();
        ft.addToBackStack(null);
    }
}