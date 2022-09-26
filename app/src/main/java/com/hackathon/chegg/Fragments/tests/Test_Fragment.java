package com.hackathon.chegg.Fragments.tests;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.chegg.R;
import com.hackathon.chegg.databinding.FragmentTestBinding;


public class Test_Fragment extends Fragment {

    private FragmentTestBinding binding;

    public Test_Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       binding=FragmentTestBinding.inflate(inflater);
       return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.cms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new IndividualTestFragment())
                        .addToBackStack("testFragment")
                        .setReorderingAllowed(true)
                        .commit();
            }
        });
    }
}