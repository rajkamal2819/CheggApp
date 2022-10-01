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
 * Use the {@link BonesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BonesFragment extends Fragment implements ModuleAdapter.onClickListener{

    private List<ModuleModel> nameL;
    private ModuleAdapter mModuleAdapter;
    private List<String> wikinames;
    private RecyclerView rv;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BonesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BonesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BonesFragment newInstance(String param1, String param2) {
        BonesFragment fragment = new BonesFragment();
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
        View view = inflater.inflate(R.layout.fragment_bones, container, false);

        rv = view.findViewById(R.id.bonesrv);

        nameL = new ArrayList<>();
        nameL.add(new ModuleModel("Femur","human_femur","Femur"));
        nameL.add(new ModuleModel("Heart","human_heart","Heart"));
        nameL.add(new ModuleModel("Sacrum","human_sacrum","Sacrum"));
        nameL.add(new ModuleModel("Thoracic vertebrae","human_thoracic_vertebra_t5_or_t6","Thoracic_vertebrae"));
        nameL.add(new ModuleModel("Pygmy hippopotamus","pygmy_hippopotamus","Pygmy_hippopotamus"));
        nameL.add(new ModuleModel("Armadillo","armadillo","Armadillo"));
        nameL.add(new ModuleModel("Greater mouse-eared bat","myotis_myotis","Greater_mouse-eared_bat"));
        nameL.add(new ModuleModel("Blue Whale","nhm_blue_whale_6k","Blue_whale"));
        nameL.add(new ModuleModel("Human Skull","rojo-hs-1___human_skull","Skull#Humans"));


        List<String> names = nameL.stream().map(ModuleModel::getName).collect(Collectors.toList());


        mModuleAdapter = new ModuleAdapter(names,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
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