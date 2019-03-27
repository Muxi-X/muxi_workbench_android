package com.example.hp.muxi_workbench_android.block.main.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
    private List<String> messageArray;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        messageArray = new ArrayList<String>();
        initData();
        viewFlipper = root.findViewById(R.id.view_flipper);
        initViewFlipper(root);
        return root;
    }

    private void initData() {
        messageArray.add("1");
        messageArray.add("  2");
        messageArray.add("    3");
    }

    private void initViewFlipper(View root) {
        for (int i = 0; i < messageArray.size(); i++) {
            TextView textView = (TextView) View.inflate(getContext(), R.layout.message_text, null);
            textView.setText(messageArray.get(i));
            viewFlipper.addView(textView);
        }
        viewFlipper.startFlipping();
    }

    @Override
    public void onStop() {
        super.onStop();
        viewFlipper.stopFlipping();
        viewFlipper.removeAllViews();
    }
}
