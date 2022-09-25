package com.hackathon.chegg.STEMSubject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.chegg.Adapters.ModuleAdapter;
import com.hackathon.chegg.Augmented;
import com.hackathon.chegg.Information;
import com.hackathon.chegg.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChemFragment extends Fragment implements ModuleAdapter.onClickListener {

    private List<ModuleModel> nameL;
    private ModuleAdapter mModuleAdapter;
    private RecyclerView rv;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChemFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChemFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChemFragment newInstance(String param1, String param2) {
        ChemFragment fragment = new ChemFragment();
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
        View view = inflater.inflate(R.layout.fragment_chem, container, false);

        rv = view.findViewById(R.id.chemrv);

        nameL = new ArrayList<>();
        nameL.add(new ModuleModel("DDT","ddt_molecule","DDT"));
        nameL.add(new ModuleModel("Uranium","element_con_uranium","Uranium"));
        nameL.add(new ModuleModel("Structure of Ice","structure_of_ice","Ice"));
        nameL.add(new ModuleModel("Structure of Liquid water","structure_of_liquid_water","Liquid_water_content"));
        nameL.add(new ModuleModel("Periodic Table","the_3d_periodic_table","Periodic_table"));


        List<String> names = nameL.stream().map(ModuleModel::getName).collect(Collectors.toList());

        mModuleAdapter = new ModuleAdapter(names,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2, GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(mModuleAdapter);

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