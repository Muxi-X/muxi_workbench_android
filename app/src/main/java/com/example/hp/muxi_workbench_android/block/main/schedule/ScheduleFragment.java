package com.example.hp.muxi_workbench_android.block.main.schedule;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.muxi_workbench_android.App;
import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.adapter.ScheduleAdapter;
import com.example.hp.muxi_workbench_android.base.BaseFragment;
import com.example.hp.muxi_workbench_android.net.RetrofitFactory;
import com.example.hp.muxi_workbench_android.net.bean.ScheduleList;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class ScheduleFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private List<ScheduleList.StatuListBean> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_schedule, container, false);
        mRecyclerView = root.findViewById(R.id.schedule_recycle);
        initData();
        return root;
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new ScheduleAdapter(list));
    }

    private void initData() {
        RetrofitFactory.getRetrofitService().getScheduleList(App.getToken(),1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ScheduleList>() {
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onComplete() {
                    }
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(ScheduleList scheduleList) {
                        list.clear();
                        list.addAll(scheduleList.getStatuList());
                        Log.i("SCHEDULE:","list size = " + list.size());
                        if(mRecyclerView.getAdapter() != null)mRecyclerView.getAdapter().notifyDataSetChanged();
                        else initRecyclerView();
                    }
                });
    }

}
