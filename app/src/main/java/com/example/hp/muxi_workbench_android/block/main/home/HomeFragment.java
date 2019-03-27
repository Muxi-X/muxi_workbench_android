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


public class HomeFragment extends Fragment {

    private ViewFlipper viewFlipper;
    private String[] messageArray = {"祝1生日快乐","祝2生日快乐"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        viewFlipper = root.findViewById(R.id.view_flipper);
        initViewFlipper(root);
        return root;
    }

    private void initViewFlipper(View root) {
        for (String aMessageArray : messageArray) {
            TextView textView = (TextView) View.inflate(getContext(), R.layout.message_text, null);
            textView.setText(aMessageArray);
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
