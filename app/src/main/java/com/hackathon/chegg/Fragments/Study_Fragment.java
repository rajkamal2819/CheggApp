package com.hackathon.chegg.Fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.chegg.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Study_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Study_Fragment extends Fragment {

    private CardView science;
    private CardView engg;
    private CardView tech;
    private CardView maths;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Study_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Study_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Study_Fragment newInstance(String param1, String param2) {
        Study_Fragment fragment = new Study_Fragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_study_, container, false);

        science = view.findViewById(R.id.ScienceCard);
        maths = view.findViewById(R.id.MathsCard);
        tech = view.findViewById(R.id.TechnologyCard);
        engg = view.findViewById(R.id.EngineeringCard);

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getActivity().getSupportFragmentManager();

                fm.beginTransaction().
                        replace(R.id.fragment_container, new ScienceFragment(), "NewFragmentTag")
                        .setReorderingAllowed(true)
                        .addToBackStack("scienceFragment")
                        .commit();


            }
        });

        tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm=getActivity().getSupportFragmentManager();

                fm.beginTransaction().
                replace(R.id.fragment_container, new TechFragment(), "NewFragmentTag")
                        .setReorderingAllowed(true)
                        .addToBackStack("studyFragment")
                        .commit();

            }
        });

        engg.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                FragmentManager fm=getActivity().getSupportFragmentManager();

                fm.beginTransaction().
                        replace(R.id.fragment_container, new EnggFragment(), "NewFragmentTag")
                        .setReorderingAllowed(true)
                        .addToBackStack("engFragment")
                        .commit();


            }
        });

        maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm=getActivity().getSupportFragmentManager();

                fm.beginTransaction().
                        replace(R.id.fragment_container, new MathFragment(), "NewFragmentTag")
                        .setReorderingAllowed(true)
                        .addToBackStack("mathFragment")
                        .commit();


            }
        });

        return view;
    }
}