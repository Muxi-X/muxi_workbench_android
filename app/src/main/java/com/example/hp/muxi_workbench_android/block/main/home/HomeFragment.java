package com.example.hp.muxi_workbench_android.block.main.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.hp.muxi_workbench_android.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private ViewFlipper viewFlipper;
    private RecyclerView recyclerView;
    private List<String> messageArray;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initData();
        initViewFlipper(root);
        initRecyclerView(root);
        return root;
    }

    private void initData() {
        messageArray = new ArrayList<>();
        messageArray.add("1");
        messageArray.add("  2");
        messageArray.add("    3");
    }

    private void initRecyclerView(View root) {
        recyclerView = root.findViewById(R.id.home_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new HomeAdapter());
    }

    private void initViewFlipper(View root) {
        viewFlipper = root.findViewById(R.id.view_flipper);
        for (int i = 0; i < messageArray.size(); i++) {
            TextView textView = (TextView) View.inflate(getContext(), R.layout.message_text, null);
            textView.setText(messageArray.get(i));
            viewFlipper.addView(textView);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        viewFlipper.stopFlipping();
        viewFlipper.removeAllViews();
    }
}
