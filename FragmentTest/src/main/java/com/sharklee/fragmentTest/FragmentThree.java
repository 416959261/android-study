package com.sharklee.fragmentTest;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * Created by Administrator on 2015/10/9.
 */
public class FragmentThree extends Fragment{

    private static final String TAG = "FragmentThree";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.layout_fragmentthree,container,false);
        ViewParent parent = view.getParent();
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i(TAG,"onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        Log.i(TAG,"onViewStateRestored");
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG,"onAttach");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG,"onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i(TAG,"onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG,"onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG,"onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG,"onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG,"onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(TAG,"onDetach");
        super.onDetach();
    }
}
