package com.example.hp.muxi_workbench_android.block.main.project.Viewdel;

import android.app.Application;

import com.example.hp.muxi_workbench_android.block.main.project.Repo.ProjectRepertory;
import com.example.hp.muxi_workbench_android.block.main.project.projectdata.ProjectData;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ProjectViewModel extends AndroidViewModel {
    private MutableLiveData<ProjectData>projectData;

    private ProjectRepertory repertory;

    public ProjectViewModel(@NonNull Application application) {
        super(application);
    }

    public void setRepertory(ProjectRepertory repertory) {
        this.repertory = repertory;
    }

    public LiveData<ProjectData> getProjectData(){

        //todo...
        return null;
    }



}
