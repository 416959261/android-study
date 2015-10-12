package com.sharklee.fragmentTest1;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ContentActivity extends AppCompatActivity
{

    private ContentFragment mContentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        FragmentManager fm = getFragmentManager();
        mContentFragment = (ContentFragment) fm.findFragmentById(R.id.id_fragment_container);

        if(mContentFragment == null )
        {
            String title = getIntent().getStringExtra(ContentFragment.ARGUMENT);
            mContentFragment = ContentFragment.newInstance(title);
            fm.beginTransaction().add(R.id.id_fragment_container,mContentFragment).commit();
        }

    }
}
