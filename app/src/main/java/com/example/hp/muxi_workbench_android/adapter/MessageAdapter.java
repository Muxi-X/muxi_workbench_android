package com.example.hp.muxi_workbench_android.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.net.bean.MessageList;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {

    private List<MessageList.ListBean> list;

    public MessageAdapter(List<MessageList.ListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item,parent,false);
        return new MessageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MessageHolder extends RecyclerView.ViewHolder {

        private TextView nameTv;
        private TextView actionTv;
        private TextView sourceTv;
        private TextView dateTv;
        private TextView kindTv;
        private String kind;


        public MessageHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name_tv);
            actionTv = itemView.findViewById(R.id.action_tv);
            sourceTv = itemView.findViewById(R.id.source_tv);
            dateTv = itemView.findViewById(R.id.date_tv);
            kindTv= itemView.findViewById(R.id.kind_tv);

        }

        public void bind(MessageList.ListBean bean){
            nameTv.setText(bean.getFromName());
            actionTv.setText(bean.getAction());
            sourceTv.setText(bean.getSourceID());
            dateTv.setText(bean.getTime());
            if(bean.isReaded())kind = "已读";
            else kind = "";
            kindTv.setText(kind);

        }
    }
}
