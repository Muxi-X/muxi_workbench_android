package com.example.hp.muxi_workbench_android.block.main.home;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.hp.muxi_workbench_android.R;
import com.example.hp.muxi_workbench_android.adapter.HomeAdapter;
import com.example.hp.muxi_workbench_android.block.main.schedule.EditorActivity;
import com.example.hp.muxi_workbench_android.net.RetrofitFactory;
import com.example.hp.muxi_workbench_android.net.bean.FeedList;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import rx.Observer;
import rx.schedulers.Schedulers;


public class HomeFragment extends Fragment {

    private ViewFlipper viewFlipper;
    private RecyclerView mRecyclerView;
    private List<FeedList.DataListBean> list = new ArrayList<>();
    private List<String> messageArray = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = root.findViewById(R.id.home_recycle);
        initData();
        initViewFlipper(root);
        return root;
    }

    private void initData() {
        RetrofitFactory.getRetrofitService().getFeedList("token",1)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.immediate())
                .subscribe(new Observer<FeedList>() {
                    @Override
                    public void onCompleted() { }
                    @Override
                    public void onError(Throwable e) { }
                    @Override
                    public void onNext(FeedList feedList) {
                        list.clear();
                        list.addAll(feedList.getDataList());
                        if(mRecyclerView.getAdapter() == null) initRecyclerView();
                        else mRecyclerView.getAdapter().notifyDataSetChanged();
                    }
                });

        messageArray.add("Welcome to my app");
        messageArray.add("I'm tired now");
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new HomeAdapter(list));
    }

    private void initViewFlipper(View root) {
        viewFlipper = root.findViewById(R.id.view_flipper);
        for (int i = 0; i < messageArray.size(); i++) {
            TextView textView = (TextView) View.inflate(getContext(), R.layout.message_text, null);
            textView.setText(messageArray.get(i));
            viewFlipper.addView(textView);
        }
        viewFlipper.setOnClickListener(v -> EditorActivity.startEditorActivity(getContext()));
    }

    @Override
    public void onStop() {
        super.onStop();
        viewFlipper.stopFlipping();
        viewFlipper.removeAllViews();
    }
}
