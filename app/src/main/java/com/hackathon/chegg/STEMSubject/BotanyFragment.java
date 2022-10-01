package com.hackathon.chegg.STEMSubject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.hackathon.chegg.Adapters.ModuleAdapter;
import com.hackathon.chegg.Augmented;
import com.hackathon.chegg.Fragments.EnggFragment;
import com.hackathon.chegg.Fragments.ScienceFragment;
import com.hackathon.chegg.Information;
import com.hackathon.chegg.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BotanyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BotanyFragment extends Fragment implements ModuleAdapter.onClickListener {

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

    public BotanyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BotanyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BotanyFragment newInstance(String param1, String param2) {
        BotanyFragment fragment = new BotanyFragment();
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
        View view = inflater.inflate(R.layout.fragment_botany, container, false);

        rv = view.findViewById(R.id.botanyrv);

        nameL = new ArrayList<>();
        nameL.add(new ModuleModel("Rafflesia arnoldii","rafflesia_arnoldii_flower","Rafflesia_arnoldii"));
        nameL.add(new ModuleModel("Pine Tree","pine_tree","Pine_tree"));
        nameL.add(new ModuleModel("Taxodium distichum","bald_cypress","Taxodium_distichum"));
        nameL.add(new ModuleModel("Oak Tree","oak_trees","Oak"));
        nameL.add(new ModuleModel("Fern","ferns_lowpoly_model","Fern"));
        nameL.add(new ModuleModel("Maple Tree","maple_tree","Maple"));
        nameL.add(new ModuleModel("Banana Tree","banana_tree_low_poly","Banana"));
        nameL.add(new ModuleModel("Monstera Tree","monstera_tree","Monstera"));
        nameL.add(new ModuleModel("Lavandula","lavender","Lavandula"));


        List<String> names = nameL.stream().map(ModuleModel::getName).collect(Collectors.toList());
        mModuleAdapter = new ModuleAdapter(names,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(mModuleAdapter);

        ImageButton back = view.findViewById(R.id.backtosci);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, new ScienceFragment(), "NewFragmentTag");
                ft.commit();
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