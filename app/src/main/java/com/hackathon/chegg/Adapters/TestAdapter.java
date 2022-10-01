package com.hackathon.chegg.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.chegg.Models.TestModel;
import com.hackathon.chegg.R;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private ArrayList<TestModel> list;
    private Context context;

    public TestAdapter(ArrayList<TestModel> list, Context context) {
        this.list = list;
        //   Log.i("TestHistoryAdapter",list.toString());
        this.context = context;
    }

    @NonNull
    @Override
    public TestAdapter.TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TestAdapter.TestViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.test_history_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.TestViewHolder holder, int position) {
        holder.setDetails(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TestViewHolder extends RecyclerView.ViewHolder{

        TextView testName;
        TextView testMarks;
        TextView testDate;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            testDate = itemView.findViewById(R.id.testTimestamp);
            testName = itemView.findViewById(R.id.testTagName);
            testMarks = itemView.findViewById(R.id.testMarks);
        }

        public void setDetails(TestModel model) {

            testMarks.setText(model.getMarksScored()+"/"+model.getMaxScore());
            testName.setText(model.getTestTagName());
            testDate.setText(model.getDate());

        }

    }

}
