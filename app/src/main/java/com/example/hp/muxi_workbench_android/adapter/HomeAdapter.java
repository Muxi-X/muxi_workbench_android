package com.example.hp.muxi_workbench_android.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.net.bean.FeedList;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {

    private static final int TYPE_DIVISION = 1;
    private static final int TYPE_STATE = 2;
    private List<FeedList.DataListBean> list = new ArrayList<>();

    public HomeAdapter(List<FeedList.DataListBean> beans){
        String time = "";
        for (int i = 0; i < beans.size(); i++) {
            if(!beans.get(i).getTimeday().equals(time)){
                time = beans.get(i).getTimeday();
                FeedList.DataListBean.UserBean userBean = new FeedList.DataListBean.UserBean();
                userBean.setId(-1);
                userBean.setName(beans.get(i).getTimeday());
                FeedList.DataListBean dataListBean = new FeedList.DataListBean();
                dataListBean.setUser(userBean);
                list.add(dataListBean);
            }
            list.add(beans.get(i));

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getUser().getId() == -1)return TYPE_DIVISION;
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
            ((DivisionHolder)viewHolder).bind(list.get(i).getUser().getName());
        }else if (viewHolder instanceof StateHolder){
            ((StateHolder)viewHolder).bind(list.get(i).getUser(),list.get(i).getSource(),list.get(i).getAction());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
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
            nameTv = itemView.findViewById(R.id.name_tv);
            actionTv = itemView.findViewById(R.id.action_tv);
            projectTv = itemView.findViewById(R.id.project_tv);
        }

        public void bind(FeedList.DataListBean.UserBean userBean, FeedList.DataListBean.SourceBean sourceBean,String action){
            nameTv.setText(userBean.getName());
            actionTv.setText(action);
            projectTv.setText(sourceBean.getObject_name());
        }
    }
}
