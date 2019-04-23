package com.example.hp.muxi_workbench_android.block.main.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.block.main.project.projectdata.ProjectData;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.hp.muxi_workbench_android.block.main.project.projectdata.ProjectData.ListBean;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectRecycleAdapter extends RecyclerView.Adapter<ProjectRecycleAdapter.ProjectItem> {

    private List<ListBean> mdata;
    private OnItemClickListener itemClickListener;


    public ProjectRecycleAdapter( OnItemClickListener listener){
        itemClickListener=listener;
    }

    public void setData(List<ListBean> list ){
        if (mdata==null){
            mdata=list;
            notifyItemRangeInserted(0,list.size());
        }else {
            DiffUtil.DiffResult result=DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mdata.size();
                }

                @Override
                public int getNewListSize() {
                    return list.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    if (mdata.get(oldItemPosition).getProjectID()==list.get(newItemPosition).getProjectID())
                        return true;

                    return false;
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    ListBean old=mdata.get(oldItemPosition);
                    ListBean newBean=list.get(newItemPosition);

                    return old.getProjectName().equals(newBean.getProjectName())
                            &&old.getIntro().equals(newBean.getIntro())
                            &&old.getProjectID()==newBean.getProjectID()
                            &&old.getUserCount()==newBean.getUserCount();
                }
            });

            mdata=list;
            result.dispatchUpdatesTo(this);


        }

    }
    @NonNull
    @Override
    public ProjectItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.project_item,parent,false);
        ProjectItem item=new ProjectItem(v);

        return item;
    }


    @Override
    public void onBindViewHolder(@NonNull ProjectItem holder, int position) {
        //todo ..
        holder.bind(mdata.get(position));
        holder.holderView.setOnClickListener(v -> itemClickListener.onItemClick(v,position));
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public void disconect(){
        itemClickListener=null;
    }


    class ProjectItem extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        View holderView;
        public ProjectItem(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.project_name);
            imageView=itemView.findViewById(R.id.project_image);
            holderView=itemView;
        }



        public void bind(ProjectData.ListBean data){
            textView.setText(data.getProjectName());

        }


    }

    public interface OnItemClickListener{
        void onItemClick(View v,int position);

    }

}
