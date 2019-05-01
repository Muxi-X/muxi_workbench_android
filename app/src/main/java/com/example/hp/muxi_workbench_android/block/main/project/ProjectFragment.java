package com.example.hp.muxi_workbench_android.block.main.project;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.block.main.project.Viewdel.ProjectViewModel;

import java.util.Objects;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectFragment extends Fragment {

    private ProjectViewModel model;
    private ProjectRecycleAdapter recycleAdapter;
    private RecyclerView recyclerView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_project,container,false);
        model=ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(ProjectViewModel.class);
        recyclerView=view.findViewById(R.id.project_recycle);
        recycleAdapter=new ProjectRecycleAdapter((v,position)->{

            //todo
        });

        subscribeToModel(model);
        return view;
    }

    private void onItemClik(View v,int p){


    }

    private void subscribeToModel(ProjectViewModel model){
        model.getProjectData().observe(this,listBean -> {
              recycleAdapter.setData(listBean.getList());

        });


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        recycleAdapter.disconect();
    }



}
