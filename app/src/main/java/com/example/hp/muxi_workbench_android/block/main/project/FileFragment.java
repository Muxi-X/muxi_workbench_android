package com.example.hp.muxi_workbench_android.block.main.project;

import android.os.Bundle;

import com.example.hp.muxi_workbench_android.base.BaseFragment;

public class FileFragment extends BaseFragment {


    public static FileFragment newInstance() {
        
        Bundle args = new Bundle();
        
        FileFragment fragment = new FileFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
