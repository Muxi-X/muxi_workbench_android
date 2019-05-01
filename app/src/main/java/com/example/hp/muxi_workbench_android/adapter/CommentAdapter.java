package com.example.hp.muxi_workbench_android.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.net.bean.ScheduleInfo;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {

    private final List<ScheduleInfo.CommentListBean> list;

    public CommentAdapter(ArrayList<ScheduleInfo.CommentListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_comment,parent,false);
        return new CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CommentHolder extends RecyclerView.ViewHolder{

        private TextView mContentTv;
        private TextView mDateTv;
        private TextView mNameTv;
        private ImageView mCircleIv;

        public CommentHolder(@NonNull View itemView) {
            super(itemView);
            mContentTv = itemView.findViewById(R.id.content_tv);
            mDateTv = itemView.findViewById(R.id.date_tv);
            mNameTv = itemView.findViewById(R.id.user_name_tv);
            mCircleIv = itemView.findViewById(R.id.circle_iv);
        }

        public void bind(ScheduleInfo.CommentListBean commentListBean) {
            mContentTv.setText(commentListBean.getContent());
            mNameTv.setText(commentListBean.getUsername());
            mDateTv.setText(commentListBean.getTime());
        }
    }
}
