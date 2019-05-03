package com.example.hp.muxi_workbench_android.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    public static final  String TAG="Fragment";
    public static int num=0;
    protected   String name=getClass().getSimpleName()+num;



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "------------onDestroyView:  "+name);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.i(TAG, "------------onActivityCreated:  "+name);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        num++;
        Log.i(TAG, "-------------onAttach: "+name);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "--------------onCreate:  "+name);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "---------------onCreateView: "+name);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "-----------------onDetach: "+name);
    }

    @NonNull
    @Override
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        return super.onGetLayoutInflater(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "-----------onStart: "+name);
    }

    @Override
    public void onStop() {
        Log.i(TAG, "-----------onStop: "+name);
        super.onStop();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "-----------onViewCreated: "+name);
    }
    @Override
    public  void onResume(){
        super.onResume();
        Log.i(TAG, "---------------onResume: "+name);
    }


}
