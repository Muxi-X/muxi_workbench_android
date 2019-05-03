package com.example.hp.muxi_workbench_android.block.main.project;

import android.os.Bundle;

import com.example.hp.muxi_workbench_android.base.BaseFragment;

public class DocumentFragment  extends BaseFragment {

    public static DocumentFragment newInstance() {

        Bundle args = new Bundle();

        DocumentFragment fragment = new DocumentFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
