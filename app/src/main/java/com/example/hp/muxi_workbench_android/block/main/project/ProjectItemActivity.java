package com.example.hp.muxi_workbench_android.block.main.project;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.adapter.MainPagerAdapter;
import com.example.hp.muxi_workbench_android.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProjectItemActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private FragmentPagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        findView();




    }

    private void findView(){
        mTabLayout=findViewById(R.id.tab_layout);
        mViewPager=findViewById(R.id.view_pager_project);
        initView();

    }
    private void initView(){
        List<BaseFragment> list=new ArrayList<>();
        list.add(DocumentFragment.newInstance());
        list.add(FileFragment.newInstance());
        mPagerAdapter=new MainPagerAdapter<BaseFragment>(getSupportFragmentManager(),list){
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                if (position==0)return "文档";
                else
                    return "文件";
            }
        };
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);

    }
}
