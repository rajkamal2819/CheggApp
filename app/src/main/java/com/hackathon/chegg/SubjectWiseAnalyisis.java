package com.hackathon.chegg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;

public class SubjectWiseAnalyisis extends AppCompatActivity {

    private String[] subjectList = {"Linux","SQL","Bash","Html","WordPress","PHP"};
    Spinner mSpinner;
    ArrayList<Entry> list;
    LineChart mLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_wise_analyisis);

        mSpinner = findViewById(R.id.spinner1);
        ArrayAdapter ad = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, subjectList);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(ad);

        list = marksList("Linux");

        mLineChart = findViewById(R.id.linechartSub);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Object ob = adapterView.getAdapter().getItem(i);
                list = marksList(ob.toString());
                LineDataSet lineDataSet1 = new LineDataSet(list,"Max Score: 100");
                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                dataSets.add(lineDataSet1);

                lineDataSet1.setDrawFilled(true);
                if (Utils.getSDKInt() >= 18) {
                    // fill drawable only supported on api level 18 and above
                    Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.fade_red);
                    lineDataSet1.setFillDrawable(drawable);
                }
                else {
                    lineDataSet1.setFillColor(Color.BLACK);
                }

                LineData data = new LineData(dataSets);
                mLineChart.setData(data);
                mLineChart.invalidate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                list = marksList("Linux");
                LineDataSet lineDataSet1 = new LineDataSet(list,"Max Score: 100");
                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                dataSets.add(lineDataSet1);

                LineData data = new LineData(dataSets);
                mLineChart.setData(data);
                mLineChart.invalidate();

            }
        });

    }

    // Test vs marks graph
    public static ArrayList<Entry> marksList(String subject){
        ArrayList<Entry> dataVals = new ArrayList<>();
        switch (subject){
            case "Linux":
                dataVals.add(new Entry(0,20));
                dataVals.add(new Entry(1,22));
                dataVals.add(new Entry(2,8));
                dataVals.add(new Entry(3,10));
                dataVals.add(new Entry(4,30));
                dataVals.add(new Entry(5,66));
                dataVals.add(new Entry(7,35));
                break;
            case "SQL":
                dataVals.add(new Entry(0,66));
                dataVals.add(new Entry(1,80));
                dataVals.add(new Entry(2,67));
                dataVals.add(new Entry(3,90));
                dataVals.add(new Entry(4,100));
                dataVals.add(new Entry(5,56));
                dataVals.add(new Entry(6,89));
                dataVals.add(new Entry(7,77));
                dataVals.add(new Entry(8,46));
                break;

            case "Html":
                dataVals.add(new Entry(0,70));
                dataVals.add(new Entry(1,6));
                dataVals.add(new Entry(2,58));
                dataVals.add(new Entry(3,99));
                dataVals.add(new Entry(4,10));
                dataVals.add(new Entry(5,56));
                dataVals.add(new Entry(6,48));
                dataVals.add(new Entry(7,48));
                dataVals.add(new Entry(8,46));
                break;

            case "Bash":
                dataVals.add(new Entry(0,49));
                dataVals.add(new Entry(1,80));
                dataVals.add(new Entry(2,67));
                dataVals.add(new Entry(3,90));
                dataVals.add(new Entry(4,10));
                dataVals.add(new Entry(5,56));
                dataVals.add(new Entry(6,80));
                dataVals.add(new Entry(7,77));
                dataVals.add(new Entry(8,46));
                break;

            case "WordPress":
                dataVals.add(new Entry(0,67));
                dataVals.add(new Entry(1,88));
                dataVals.add(new Entry(2,0));
                dataVals.add(new Entry(3,90));
                dataVals.add(new Entry(4,55));
                dataVals.add(new Entry(5,56));
                dataVals.add(new Entry(6,8));
                dataVals.add(new Entry(7,77));
                dataVals.add(new Entry(8,46));
                break;

        }
        return dataVals;
    }

}