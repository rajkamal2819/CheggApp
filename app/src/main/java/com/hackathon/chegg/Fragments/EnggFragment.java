package com.hackathon.chegg.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.hackathon.chegg.R;
import com.hackathon.chegg.STEMSubject.EngineFragment;
import com.hackathon.chegg.STEMSubject.ShapesFragment;
import com.hackathon.chegg.STEMSubject.ToolsFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EnggFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EnggFragment extends Fragment {

    private CardView engine;
    private CardView tools;
    private ImageButton back;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EnggFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EnggFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EnggFragment newInstance(String param1, String param2) {
        EnggFragment fragment = new EnggFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_engg, container, false);
        engine = view.findViewById(R.id.EngineCard);
        tools = view.findViewById(R.id.ToolsCard);

        engine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new EngineFragment(), "NewFragmentTag");
                ft.commit();
            }
        });

        tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new ToolsFragment(), "NewFragmentTag");
                ft.commit();
            }
        });

        back = view.findViewById(R.id.enggtostudy);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new Study_Fragment(), "NewFragmentTag");
                ft.commit();
            }
        });

        return view;
    }
}