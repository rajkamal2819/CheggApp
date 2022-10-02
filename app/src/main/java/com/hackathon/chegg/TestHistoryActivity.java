package com.hackathon.chegg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.hackathon.chegg.Adapters.TestAdapter;
import com.hackathon.chegg.Models.TestModel;
import com.hackathon.chegg.databinding.ActivityTestHistoryBinding;

import java.util.ArrayList;

public class TestHistoryActivity extends AppCompatActivity {

    ArrayList<TestModel> testList;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_history);

        mRecyclerView = findViewById(R.id.recyclerView1);
        testList = populateTestList();
        Log.i("TestHistoryActivity",testList.size()+"");
        TestAdapter adapter = new TestAdapter(testList,this);
        Log.i("TestHistoryActivity",adapter.getItemCount()+"");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(TestHistoryActivity.this, RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);


    }

    private ArrayList<TestModel> populateTestList(){

        ArrayList<TestModel> list = new ArrayList<>();
        list.add(new TestModel("Linux-112B","10/09/2022 4:32 PM",50,100));
        list.add(new TestModel("Bash-23A","30/06/2022 2:00 PM",43,100));
        list.add(new TestModel("Docker-11B","16/05/2022 3:00 AM",70,80));
        list.add(new TestModel("Linux-98JC","21/05/2022 4:55 PM",30,100));
        list.add(new TestModel("SQL-25A","18/06/2022 4:55 PM",30,100));
        list.add(new TestModel("HTML-98B","16/05/2022 8:00 PM",90,100));

        return list;
    }


}