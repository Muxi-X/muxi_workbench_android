package com.example.hp.muxi_workbench_android.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.muxi_workbench_android.R;

public class HomeAdapter extends RecyclerView.Adapter {

    private static final int TYPE_DIVISION = 1;
    private static final int TYPE_STATE = 2;

    @Override
    public int getItemViewType(int position) {
        int type = TYPE_DIVISION;
        //todo
        return type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;

        if (i == TYPE_DIVISION){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_division_item,viewGroup,false);
            return new DivisionHolder(view);
        }else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_state_item,viewGroup,false);
            return new StateHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof DivisionHolder){
            ((DivisionHolder)viewHolder).bind();
        }else if (viewHolder instanceof StateHolder){
            ((StateHolder)viewHolder).bind();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class DivisionHolder extends RecyclerView.ViewHolder {

        public DivisionHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(){

        }
    }

    class StateHolder extends RecyclerView.ViewHolder {

        public StateHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(){

        }
    }
}
