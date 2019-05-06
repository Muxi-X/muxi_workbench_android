package com.example.hp.muxi_workbench_android.block.main.schedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hp.muxi_workbench_android.App;
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

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ScheduleActivity extends BaseActivity {

    private static final String SID_KEY = "sid";
    private static final String NAME_KEY = "name";
    private static final String AVATAR_KEY = "avatar";
    private int sid;
    private String name;
    private String avatar;

    private TextView mContentTv;
    private TextView mDateTv;
    private TextView mNameTv;

    private TextView mLikeTv;
    private TextView mCommentTv;
    private TextView mEditTv;

    private ImageView mCircleIv;
    private RecyclerView mCommentRv;

    private ArrayList<ScheduleInfo.CommentListBean> list = new ArrayList<>();

    public static void startScheduleActivity(Context context, int sid, String name, String avatar){
        Intent intent = new Intent(context,ScheduleActivity.class);
        intent.putExtra(SID_KEY,sid);
        intent.putExtra(NAME_KEY,name);
        intent.putExtra(AVATAR_KEY,avatar);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        sid = getIntent().getIntExtra(SID_KEY,0);
        name = getIntent().getStringExtra(NAME_KEY);
        avatar = getIntent().getStringExtra(AVATAR_KEY);
        initView();
        initDate();
    }

    private void initDate() {
        RetrofitFactory.getRetrofitService().getScheduleInfo(App.getToken(),sid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ScheduleInfo>() {
                    @Override
                    public void onError(Throwable e) {
                        Log.i("SCHEDULE_ACTIVITY:",e.getMessage());
                    }

                    @Override
                    public void onComplete() { }

                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onNext(ScheduleInfo scheduleInfo) {
                        list.clear();
                        list.addAll(scheduleInfo.getCommentList());
                        mContentTv.setText(scheduleInfo.getContent());
                        mDateTv.setText(scheduleInfo.getTime());

                        if(mCommentRv.getAdapter() != null)mCommentRv.getAdapter().notifyDataSetChanged();
                        else initRv();
                    }
                });
    }

    private void initView() {
        mContentTv = findViewById(R.id.content_tv);
        mDateTv = findViewById(R.id.date_tv);
        mNameTv = findViewById(R.id.user_name_tv);
        mNameTv.setText(name);

        mLikeTv = findViewById(R.id.like_tv);
        mContentTv = findViewById(R.id.content_tv);
        mEditTv = findViewById(R.id.edit_tv);

        mCircleIv = findViewById(R.id.circle_iv);
        Glide.with(this).load(avatar).into(mCircleIv);

        mCommentRv = findViewById(R.id.comment_rv);
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
