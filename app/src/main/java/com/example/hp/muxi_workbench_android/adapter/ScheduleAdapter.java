package com.example.hp.muxi_workbench_android.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.net.bean.ScheduleList;

import java.util.List;

import rx.schedulers.Schedulers;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleHolder> {

    private final List<ScheduleList.StatuListBean> list;

    public ScheduleAdapter(List<ScheduleList.StatuListBean> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ScheduleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_item_schedule,viewGroup,false);
        return new ScheduleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleHolder scheduleHolder, int i) {
        scheduleHolder.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ScheduleHolder extends RecyclerView.ViewHolder{

        private TextView mContentTv;
        private TextView mDateTv;
        private TextView mNameTv;

        private TextView mLikeTv;
        private TextView mCommentTv;
        private TextView mEditTv;

        private ImageView mCircleIv;
        private ImageView mPullIv;


        public ScheduleHolder(@NonNull View itemView) {
            super(itemView);
            mContentTv = itemView.findViewById(R.id.content_tv);
            mDateTv = itemView.findViewById(R.id.date_tv);
            mNameTv = itemView.findViewById(R.id.user_name_tv);

            mLikeTv = itemView.findViewById(R.id.like_tv);
            mContentTv = itemView.findViewById(R.id.content_tv);
            mEditTv = itemView.findViewById(R.id.edit_tv);

            mCircleIv = itemView.findViewById(R.id.circle_iv);
            mPullIv = itemView.findViewById(R.id.pull_down_iv);

        }

        public void bind(ScheduleList.StatuListBean o) {

        }
    }
}
