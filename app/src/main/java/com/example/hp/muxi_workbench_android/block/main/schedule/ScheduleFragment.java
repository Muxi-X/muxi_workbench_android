package com.example.hp.muxi_workbench_android.block.main.schedule;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.adapter.ScheduleAdapter;
import com.example.hp.muxi_workbench_android.base.BaseActivity;
import com.example.hp.muxi_workbench_android.base.BaseFragment;
import com.example.hp.muxi_workbench_android.net.RetrofitFactory;
import com.example.hp.muxi_workbench_android.net.bean.ScheduleList;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import rx.Observer;
import rx.Subscription;
import rx.schedulers.Schedulers;


public class ScheduleFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private ArrayList<ScheduleList.StatuListBean> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_schedule, container, false);
        initData();
        initRecyclerView(root);
        return root;
    }

    private void initRecyclerView(View root) {
        mRecyclerView = root.findViewById(R.id.schedule_recycle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        mRecyclerView.setAdapter(new ScheduleAdapter(list));
    }

    private void initData() {
        RetrofitFactory.getRetrofitService().getScheduelList("token", 1)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.immediate())
                .subscribe(new Observer<ScheduleList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ScheduleList scheduleList) {
                        list.addAll(scheduleList.getStatuList());
                        if(mRecyclerView != null)mRecyclerView.getAdapter().notifyDataSetChanged();
                    }
                });
    }

}
