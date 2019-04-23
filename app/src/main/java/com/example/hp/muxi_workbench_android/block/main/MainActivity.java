package com.example.hp.muxi_workbench_android.block.main;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.adapter.MainPagerAdapter;
import com.example.hp.muxi_workbench_android.base.BaseActivity;
import com.example.hp.muxi_workbench_android.block.main.home.HomeFragment;
import com.example.hp.muxi_workbench_android.block.main.message.MessageFragment;
import com.example.hp.muxi_workbench_android.block.main.mine.MineFragment;
import com.example.hp.muxi_workbench_android.block.main.project.ProjectFragment;
import com.example.hp.muxi_workbench_android.block.main.schedule.ScheduleFragment;

import java.util.ArrayList;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private ViewPager viewPager;
    private ImageView home;
    private ImageView schedule;
    private ImageView project;
    private ImageView message;
    private ImageView mine;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private FragmentPagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPage();
    }

    private void initViewPage() {
        fragments.add(new HomeFragment());
        fragments.add(new ScheduleFragment());
        fragments.add(new ProjectFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MineFragment());
        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) { }
            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:select(home);break;
                    case 1:select(schedule);break;
                    case 2:select(project);break;
                    case 3:select(message);break;
                    case 4:select(mine);break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int i) { }
        });

        select(home);
    }

    private void select(ImageView selectedOne) {
        home.setActivated(false);
        schedule.setActivated(false);
        project.setActivated(false);
        message.setActivated(false);
        mine.setActivated(false);

        selectedOne.setActivated(true);
    }

    private void initView() {
        viewPager = findViewById(R.id.view_page);
        home = findViewById(R.id.home);
        schedule = findViewById(R.id.schedule);
        project = findViewById(R.id.project);
        message = findViewById(R.id.message);
        mine = findViewById(R.id.mine);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home:viewPager.setCurrentItem(0);break;
            case R.id.schedule:viewPager.setCurrentItem(1);break;
            case R.id.project:viewPager.setCurrentItem(2);break;
            case R.id.message:viewPager.setCurrentItem(3);break;
            case R.id.mine:viewPager.setCurrentItem(4);break;
        }
    }
}
