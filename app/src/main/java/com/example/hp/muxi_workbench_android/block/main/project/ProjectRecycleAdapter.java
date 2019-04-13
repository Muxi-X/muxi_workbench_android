package com.example.hp.muxi_workbench_android.block.main.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.block.main.project.projectdata.ProjectData;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectRecycleAdapter extends RecyclerView.Adapter<ProjectRecycleAdapter.ProjectItem> {

    private List<ProjectData.ListBean> mdata;


    public ProjectRecycleAdapter( List<ProjectData.ListBean> data){
        mdata=data;

    }
    @NonNull
    @Override
    public ProjectItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProjectItem item=new ProjectItem(LayoutInflater.from(parent.getContext()).inflate(R.layout.project_item,parent,false));


        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectItem holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public void disconect(){

    }
    class ProjectItem extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public ProjectItem(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.project_name);
            imageView=itemView.findViewById(R.id.project_image);

        }

        public void bind(LiveData<ProjectData.ListBean> liveData){


        }


    }

}
