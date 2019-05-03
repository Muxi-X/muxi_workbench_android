package com.example.hp.muxi_workbench_android.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.net.bean.FeedAdapterList;
import com.example.hp.muxi_workbench_android.net.bean.FeedList;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {

    private static final int TYPE_DIVISION = 1;
    private static final int TYPE_STATE = 2;
    private FeedAdapterList list;

    public HomeAdapter(List<FeedList.DataListBean> beans){
        list = new FeedAdapterList();
        for (int i = 0; i < beans.size(); i++) {
            FeedList.DataListBean.UserBean userBean = new FeedList.DataListBean.UserBean();
            FeedList.DataListBean.SourceBean sourceBean = new FeedList.DataListBean.SourceBean();
            userBean.setId(-1);
            userBean.setName(beans.get(i).getTime());
            list.getUserBeans().add(userBean);
            list.getSourceBeans().add(sourceBean);
            // 把时间当做普通item插入
            list.getUserBeans().addAll(beans.get(i).getUser());
            list.getSourceBeans().addAll(beans.get(i).getSource());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (list.getUserBeans().get(position).getId() == -1)return TYPE_DIVISION;
        else return TYPE_STATE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (i == TYPE_DIVISION){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_division_item,viewGroup,false);
            return new DivisionHolder(view);
        }else {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_state_item,viewGroup,false);
            return new StateHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof DivisionHolder){
            ((DivisionHolder)viewHolder).bind(list.getUserBeans().get(i).getName());
        }else if (viewHolder instanceof StateHolder){
            ((StateHolder)viewHolder).bind(list.getUserBeans().get(i),list.getSourceBeans().get(i));
        }
    }

    @Override
    public int getItemCount() {
        return list.getUserBeans().size();
    }

    class DivisionHolder extends RecyclerView.ViewHolder {

        private TextView dateTv;
        private TextView projectTv;

        public DivisionHolder(@NonNull View itemView) {
            super(itemView);
            dateTv = itemView.findViewById(R.id.date_tv);
            projectTv = itemView.findViewById(R.id.project_tv);
        }

        public void bind(String time){
            dateTv.setText(time);
        }
    }

    class StateHolder extends RecyclerView.ViewHolder {

        private TextView nameTv;
        private TextView actionTv;
        private TextView projectTv;

        public StateHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(FeedList.DataListBean.UserBean userBean, FeedList.DataListBean.SourceBean sourceBean){
            nameTv.setText(userBean.getName());
            //actionTv.setText(sourceBean.getKind_id());
            projectTv.setText(sourceBean.getName());
        }
    }
}
