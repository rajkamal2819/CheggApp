package com.hackathon.chegg.STEMSubject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hackathon.chegg.Adapters.ModuleAdapter;
import com.hackathon.chegg.Augmented;
import com.hackathon.chegg.BookActivity;
import com.hackathon.chegg.Information;
import com.hackathon.chegg.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EngineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EngineFragment extends Fragment implements ModuleAdapter.onClickListener{

    private List<ModuleModel> nameL;
    private ModuleAdapter mModuleAdapter;
    private RecyclerView rv;
    private FloatingActionButton btn;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EngineFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EngineFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EngineFragment newInstance(String param1, String param2) {
        EngineFragment fragment = new EngineFragment();
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
        View view = inflater.inflate(R.layout.fragment_engine, container, false);

        rv = view.findViewById(R.id.enginerv);

        nameL = new ArrayList<>();
        nameL.add(new ModuleModel("Watt steam engine","model_of_the_watt_steam_engine_with_animation","Watt_steam_engine"));
        nameL.add(new ModuleModel("3 Cylinder","three_cylinder_motorcycle_engine","Motorcycle_engine"));
        nameL.add(new ModuleModel("Steam Engine","steam_engine","Steam_engine"));
        nameL.add(new ModuleModel("Jet Engine","jet_engine","Jet_engine"));

        List<String> names = nameL.stream().map(ModuleModel::getName).collect(Collectors.toList());
        mModuleAdapter = new ModuleAdapter(names,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2, GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(mModuleAdapter);
        btn = view.findViewById(R.id.books_engine);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), BookActivity.class);
                i.putExtra("query","engine");
                startActivity(i);
            }
        });


        return view;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), Information.class);
        intent.putExtra(AstoFragment.NAME,nameL.get(position).getWikiname());
        intent.putExtra(AstoFragment.MODEL,nameL.get(position).getModel());
        startActivity(intent);
    }

    @Override
    public void onLongClick(int position) {

    }
}