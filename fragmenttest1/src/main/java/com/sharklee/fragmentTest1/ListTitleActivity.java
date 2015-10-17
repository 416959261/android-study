package com.sharklee.fragmentTest1;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ListTitleActivity extends AppCompatActivity
{

    private ListTitleFragment mListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        FragmentManager fm = getFragmentManager();
        mListFragment = (ListTitleFragment) fm.findFragmentById(R.id.id_fragment_container);

        if(mListFragment == null )
        {
            mListFragment = new ListTitleFragment();
            fm.beginTransaction().add(R.id.id_fragment_container,mListFragment).commit();
        }

    }
}
