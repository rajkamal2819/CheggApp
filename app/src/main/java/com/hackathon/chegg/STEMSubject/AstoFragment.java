package com.hackathon.chegg.STEMSubject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hackathon.chegg.Adapters.ModuleAdapter;
import com.hackathon.chegg.Augmented;
import com.hackathon.chegg.BookActivity;
import com.hackathon.chegg.Fragments.Study_Fragment;
import com.hackathon.chegg.Fragments.TechFragment;
import com.hackathon.chegg.Information;
import com.hackathon.chegg.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AstoFragment extends Fragment implements ModuleAdapter.onClickListener {

    public static final String TAG = "AstroFragment";
    public static final String NAME = "name_of_module";
    public static final String MODEL = "name_of_model";
    private List<ModuleModel> nameL;
    private ModuleAdapter mModuleAdapter;
    private RecyclerView rv;
    private ExtendedFloatingActionButton btn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_asto, container, false);

        rv = view.findViewById(R.id.astrorv);

        nameL = new ArrayList<>();
        nameL.add(new ModuleModel("Moon","the_moon","Moon"));
        nameL.add(new ModuleModel("Earth","earth (1)","Earth"));
        nameL.add(new ModuleModel("Mars","mars (1)","Mars"));
        nameL.add(new ModuleModel("Neptune","neptune new","Neptune"));
        nameL.add(new ModuleModel("Solar System","Solar System","Solar_System"));

        List<String> names = nameL.stream().map(ModuleModel::getName).collect(Collectors.toList());


        mModuleAdapter = new ModuleAdapter(names,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(mModuleAdapter);
        btn = view.findViewById(R.id.books_astro);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), BookActivity.class);
                i.putExtra(MODEL,"astronomy");
                startActivity(i);
            }
        });

        ImageButton back = view.findViewById(R.id.backtotech);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new TechFragment(), "NewFragmentTag");
                ft.commit();
            }
        });


        return view;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), Information.class);
        intent.putExtra(NAME,nameL.get(position).getWikiname());
        intent.putExtra(MODEL,nameL.get(position).getModel());
        startActivity(intent);
        Log.d(TAG, "onItemClick: "+position);
    }

    @Override
    public void onLongClick(int position) {

    }
}