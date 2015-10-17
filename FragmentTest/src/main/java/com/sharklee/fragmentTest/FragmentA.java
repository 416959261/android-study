package com.sharklee.fragmentTest;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentA extends Fragment implements OnClickListener
{
    private static final String TAG = "FragmentA";
    private Button mBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Log.i(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.layout_fragmenta, container, false);
        mBtn = (Button) view.findViewById(R.id.buttonInFragmentA);
        mBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG,"onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onClick(View v)
    {
        FragmentB fTwo = new FragmentB();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(R.id.id_content, fTwo, "B");
        tx.addToBackStack(null);
        tx.commit();

    }

}

