package com.example.hp.muxi_workbench_android.adapter;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.block.main.schedule.ScheduleActivity;
import com.example.hp.muxi_workbench_android.net.bean.ScheduleList;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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
            mContentTv.setText(o.getContent());
            mNameTv.setText(o.getUsername());
            mDateTv.setText(o.getTime());

            mContentTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ScheduleActivity.startScheduleActivity(mContentTv.getContext(),o.getSid());
                }
            });

            mPullIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPopupMenu(v);
                }
            });
        }
    }

    private void showPopupMenu(View view){
        PopupMenu popupMenu = new PopupMenu(view.getContext(),view);
        popupMenu.getMenuInflater().inflate(R.menu.schedule_menu,popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        popupMenu.getMenu().findItem(R.id.stick_cancer).setVisible(false);
        //控制不同item是否显示
    }

}
