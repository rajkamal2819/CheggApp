package com.hackathon.chegg.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.chegg.R;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ModuleViewHolder> {

    private List<String> modulesList;
    private onClickListener mOnClickListener;
    Context context;

    public ModuleAdapter(List<String> modulesList, onClickListener mOnClickListener) {
        this.modulesList = modulesList;
        this.mOnClickListener = mOnClickListener;
    }


    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_list_view, parent, false);
        return new ModuleViewHolder(view, mOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder holder, int position) {
        holder.moduleName.setText(modulesList.get(position));
        holder.moduleImage.setImageResource(R.drawable.engine);
    }

    @Override
    public int getItemCount() {
        return modulesList.size();
    }

    public class ModuleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView moduleName;
        ImageView moduleImage;
        onClickListener mOnClickListener;

        public ModuleViewHolder(@NonNull View itemView, onClickListener OnClickListener) {
            super(itemView);
            moduleName = itemView.findViewById(R.id.modulName);
            moduleImage = itemView.findViewById(R.id.moduleImage);
            mOnClickListener = OnClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface onClickListener{
        void onItemClick(int position);
        void onLongClick(int position);
    }
}
