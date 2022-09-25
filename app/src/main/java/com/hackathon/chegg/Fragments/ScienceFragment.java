package com.hackathon.chegg.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.chegg.Augmented;
import com.hackathon.chegg.Information;
import com.hackathon.chegg.R;
import com.hackathon.chegg.STEMSubject.AstoFragment;
import com.hackathon.chegg.STEMSubject.BonesFragment;
import com.hackathon.chegg.STEMSubject.BotanyFragment;


public class ScienceFragment extends Fragment {

    private CardView chem;
    private CardView bones;
    private CardView botany;



    public ScienceFragment() {
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
        View v =  inflater.inflate(R.layout.fragment_science, container, false);
        chem= v.findViewById(R.id.ScienceCard);
        chem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Augmented.class));
            }
        });

        bones= v.findViewById(R.id.OsteologyCard);
        bones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new BonesFragment(), "NewFragmentTag");
                ft.commit();
            }
        });

        botany= v.findViewById(R.id.BotanyCard);
        botany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new BotanyFragment(), "NewFragmentTag");
                ft.commit();
            }
        });
        return v;
    }
}