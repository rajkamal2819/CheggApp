package com.hackathon.chegg.STEMSubject;

import static com.hackathon.chegg.STEMSubject.AstoFragment.MODEL;

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
 * Use the {@link ShapesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShapesFragment extends Fragment implements ModuleAdapter.onClickListener {

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

    public ShapesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShapesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShapesFragment newInstance(String param1, String param2) {
        ShapesFragment fragment = new ShapesFragment();
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
        View view = inflater.inflate(R.layout.fragment_shapes, container, false);

        rv = view.findViewById(R.id.shapesrv);

        nameL = new ArrayList<>();
        nameL.add(new ModuleModel("Octahedron","octahedron","Octahedron"));
        nameL.add(new ModuleModel("Dodecahedron","dodecahedron","Dodecahedron"));
        nameL.add(new ModuleModel("Tetrahedron","tetrahedron","Tetrahedron"));
        nameL.add(new ModuleModel("Hexahedron","hexahedron","Hexahedron"));
        nameL.add(new ModuleModel("Icosahedron","icosahedron","Icosahedron"));
        nameL.add(new ModuleModel("Cylinder","cylinder","Cylinder"));

        List<String> names = nameL.stream().map(ModuleModel::getName).collect(Collectors.toList());

        mModuleAdapter = new ModuleAdapter(names,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2, GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(mModuleAdapter);
        btn = view.findViewById(R.id.books_shapes);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), BookActivity.class);
                i.putExtra(MODEL,"mathematics");
                startActivity(i);
            }
        });
        return view;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), Information.class);
        intent.putExtra(AstoFragment.NAME,nameL.get(position).getWikiname());
        intent.putExtra(MODEL,nameL.get(position).getModel());
        startActivity(intent);
    }

    @Override
    public void onLongClick(int position) {

    }
}