package com.example.hp.muxi_workbench_android.block.main.project;

import com.example.hp.muxi_workbench_android.block.main.project.projectdata.ProjectData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class ProjectViewModel extends ViewModel {
    private MutableLiveData<ProjectData>projectData;

    private ProjectRepertory repertory;

    public void setRepertory(ProjectRepertory repertory) {
        this.repertory = repertory;
    }

    public LiveData<ProjectData.ListBean> getProjectData(){

        //todo...
        return null;
    }



}
