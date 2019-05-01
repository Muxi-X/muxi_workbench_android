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

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private ViewFlipper viewFlipper;
    private RecyclerView mRecyclerView;
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
        mRecyclerView = root.findViewById(R.id.home_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new HomeAdapter());
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
