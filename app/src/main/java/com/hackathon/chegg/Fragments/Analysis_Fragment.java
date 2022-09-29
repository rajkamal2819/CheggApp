package com.hackathon.chegg.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.hackathon.chegg.R;
import com.hackathon.chegg.databinding.FragmentAnalysisBinding;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class Analysis_Fragment extends Fragment {

    public Analysis_Fragment() {
        // Required empty public constructor
    }

    FragmentAnalysisBinding binding;
    LineChart mpLineChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnalysisBinding.inflate(getLayoutInflater());

        mpLineChart = binding.chart;

        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(),"Data Set 1");
        LineDataSet lineDataSet2 = new LineDataSet(dataValues2(),"Data Set 2");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);

        LineData data = new LineData(dataSets);
        mpLineChart.setData(data);
        mpLineChart.invalidate();

        return binding.getRoot();
    }

    private ArrayList<Entry> dataValues1(){
        ArrayList<Entry> dataVals = new ArrayList<>();
        dataVals.add(new Entry(0,20));
        dataVals.add(new Entry(1,22));
        dataVals.add(new Entry(2,2));
        dataVals.add(new Entry(3,10));
        return dataVals;
    }

    private ArrayList<Entry> dataValues2(){
        ArrayList<Entry> dataVals = new ArrayList<>();
        dataVals.add(new Entry(0,12));
        dataVals.add(new Entry(2,16));
        dataVals.add(new Entry(3,23));
        dataVals.add(new Entry(5,1));
        dataVals.add(new Entry(7,10));
        return dataVals;
    }


}