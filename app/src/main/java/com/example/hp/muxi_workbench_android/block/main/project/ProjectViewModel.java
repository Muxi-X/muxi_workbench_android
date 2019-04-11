package com.example.hp.muxi_workbench_android.block.main.project;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProjectViewModel extends ViewModel {
    private MutableLiveData<ProjectData>projectData;

    public MutableLiveData<ProjectData> getProjectData(){
        //todo
        return projectData;
    }



}
