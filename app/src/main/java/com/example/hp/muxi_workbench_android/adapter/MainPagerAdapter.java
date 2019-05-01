package com.example.hp.muxi_workbench_android.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hp.muxi_workbench_android.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class MainPagerAdapter<E extends Fragment> extends FragmentPagerAdapter {
    private final List<E> list;

    public MainPagerAdapter(FragmentManager fm, List<E> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }




}
