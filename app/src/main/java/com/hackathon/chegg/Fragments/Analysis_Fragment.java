package com.hackathon.chegg.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.hackathon.chegg.R;
import com.hackathon.chegg.databinding.FragmentAnalysisBinding;

import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class Analysis_Fragment extends Fragment {

    public Analysis_Fragment() {
        // Required empty public constructor
    }

    FragmentAnalysisBinding binding;
    LineChart mpLineChart;
    PieChart pieChart;
    int[] colorArr = new int[] {Color.LTGRAY,Color.BLUE,Color.CYAN,Color.DKGRAY,Color.GREEN,Color.MAGENTA,Color.RED};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnalysisBinding.inflate(getLayoutInflater());

        /*mpLineChart = binding.chart;

        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(),"Data Set 1");
        LineDataSet lineDataSet2 = new LineDataSet(dataValues2(),"Data Set 2");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);

        LineData data = new LineData(dataSets);
        mpLineChart.setData(data);
        mpLineChart.invalidate();*/

        pieChart = binding.piechart;

        PieDataSet pieDataSet = new PieDataSet(dataValuesPC(),"");
        pieDataSet.setColors(colorArr);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);

        BarDataSet barDataSet = new BarDataSet(barValues(),"");
        BarData barData = new BarData();
        barData.addDataSet(barDataSet);
        binding.barChart.setData(barData);
        binding.barChart.invalidate();


        return binding.getRoot();
    }

    private ArrayList<BarEntry> barValues(){
        ArrayList<BarEntry> dataVals = new ArrayList<>();
        dataVals.add(new BarEntry(0,5));
        dataVals.add(new BarEntry(1,0));
        dataVals.add(new BarEntry(2,3));
        dataVals.add(new BarEntry(3,4));
        dataVals.add(new BarEntry(4,1));
        dataVals.add(new BarEntry(5,6));
        return dataVals;
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

    private ArrayList<PieEntry> dataValuesPC(){
        ArrayList<PieEntry> dataVals = new ArrayList<>();
        dataVals.add(new PieEntry(15,"Linux"));
        dataVals.add(new PieEntry(34,"Html"));
        dataVals.add(new PieEntry(23,"Docker"));
        dataVals.add(new PieEntry(86,"DevOps"));
        dataVals.add(new PieEntry(26,"Kubernetes"));
        dataVals.add(new PieEntry(17,"Laravel"));
        dataVals.add(new PieEntry(63,"SQL"));
        return dataVals;
    }



}