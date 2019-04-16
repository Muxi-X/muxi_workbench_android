package com.example.hp.muxi_workbench_android.block.main.project;

import androidx.recyclerview.widget.DiffUtil;

public class ProjectRecycleVIewDIff  extends DiffUtil.Callback {
    @Override
    public int getOldListSize() {
        return 0;
    }

    @Override
    public int getNewListSize() {
        return 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }
}
