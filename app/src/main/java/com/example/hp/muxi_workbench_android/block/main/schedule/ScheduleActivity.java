package com.example.hp.muxi_workbench_android.block.main.schedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.adapter.CommentAdapter;
import com.example.hp.muxi_workbench_android.base.BaseActivity;
import com.example.hp.muxi_workbench_android.net.RetrofitFactory;
import com.example.hp.muxi_workbench_android.net.bean.ScheduleInfo;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import rx.Observer;
import rx.schedulers.Schedulers;

public class ScheduleActivity extends BaseActivity {

    private static final String SID_KEY = "sid";
    private int sid;

    private TextView mContentTv;
    private TextView mDateTv;
    private TextView mNameTv;

    private TextView mLikeTv;
    private TextView mCommentTv;
    private TextView mEditTv;

    private ImageView mCircleIv;
    private RecyclerView mCommentRv;

    private ArrayList<ScheduleInfo.CommentListBean> list = new ArrayList<>();

    public static void startScheduleActivity(Context context, int sid){
        Intent intent = new Intent(context,ScheduleActivity.class);
        intent.putExtra(SID_KEY,sid);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        sid = getIntent().getIntExtra(SID_KEY,0);
        initView();
        initDate();
    }

    private void initDate() {
        RetrofitFactory.getRetrofitService().getScheduleInfo("token",sid)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.immediate())
                .subscribe(new Observer<ScheduleInfo>() {
                    @Override
                    public void onCompleted() { }
                    @Override
                    public void onError(Throwable e) { }
                    @Override
                    public void onNext(ScheduleInfo scheduleInfo) {
                        list.addAll(scheduleInfo.getCommentList());
                        mContentTv.setText(scheduleInfo.getContent());
                        mNameTv.setText(scheduleInfo.getUsername());
                        mDateTv.setText(scheduleInfo.getTime());
                    }
                });
    }

    private void initView() {
        mContentTv = findViewById(R.id.content_tv);
        mDateTv = findViewById(R.id.date_tv);
        mNameTv = findViewById(R.id.user_name_tv);

        mLikeTv = findViewById(R.id.like_tv);
        mContentTv = findViewById(R.id.content_tv);
        mEditTv = findViewById(R.id.edit_tv);

        mCircleIv = findViewById(R.id.circle_iv);
        mCommentRv = findViewById(R.id.comment_rv);
        initRv();
    }

    private void initRv() {
        LinearLayoutManager manager = new LinearLayoutManager(this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };

        mCommentRv.setLayoutManager(manager);
        mCommentRv.setAdapter(new CommentAdapter(list));
    }
}
