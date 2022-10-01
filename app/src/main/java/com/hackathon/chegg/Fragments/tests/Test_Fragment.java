package com.hackathon.chegg.Fragments.tests;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.chegg.R;
import com.hackathon.chegg.databinding.FragmentTestBinding;
import com.hackathon.chegg.viewmodel.TestViewModel;


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

        IndividualTestFragment individualTestFragment=new IndividualTestFragment();
        Bundle bundle=new Bundle();

        binding.cms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("subject","CMS");
                individualTestFragment.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,individualTestFragment)
                        .addToBackStack("testFragment")
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        binding.bash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle.putString("subject","Bash");
                individualTestFragment.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,individualTestFragment)
                        .addToBackStack("testFragment")
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        binding.coding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle.putString("subject","Code");
                individualTestFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,individualTestFragment)
                        .addToBackStack("testFragment")
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        binding.devops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle.putString("subject","DevOps");
                individualTestFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,individualTestFragment)
                        .addToBackStack("testFragment")
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        binding.docker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle.putString("subject","Docker");
                individualTestFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,individualTestFragment)
                        .addToBackStack("testFragment")
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        binding.linux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle.putString("subject","Linux");
                individualTestFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,individualTestFragment)
                        .addToBackStack("testFragment")
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        binding.sql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle.putString("subject","SQL");
                individualTestFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,individualTestFragment)
                        .addToBackStack("testFragment")
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        binding.random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle.putString("subject","uncategorized");
                individualTestFragment.setArguments(bundle);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,individualTestFragment)
                        .addToBackStack("testFragment")
                        .setReorderingAllowed(true)
                        .commit();
            }
        });


    }
}