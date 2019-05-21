package com.example.hp.muxi_workbench_android.block.main.message;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.muxi_workbench_android.App;
import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.adapter.MessageAdapter;
import com.example.hp.muxi_workbench_android.net.RetrofitFactory;
import com.example.hp.muxi_workbench_android.net.bean.MessageList;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MessageFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<MessageList.ListBean> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_message, container, false);
        mRecyclerView = root.findViewById(R.id.message_recycle);
        initRecyclerView();
        initData();
        return root;
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new MessageAdapter(list));
    }

    private void initData() {
        RetrofitFactory.getRetrofitService().getMessageList(App.getToken(),1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MessageList>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(MessageList messageList) {
                        list.clear();
                        list.addAll(messageList.getList());
                        if(mRecyclerView.getAdapter() == null)initRecyclerView();
                        else mRecyclerView.getAdapter().notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("MessageFragment","请求失败"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("MessageFragment","请求成功");
                    }
                });
    }
}
