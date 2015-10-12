package com.sharklee.fragmentTest1;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class ContentFragment extends Fragment
{

    private String mArgument;
    public static final String ARGUMENT = "argument";
    public static final String RESPONSE = "response";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null)
        {
            mArgument = bundle.getString(ARGUMENT);
            Intent intent = new Intent();
            intent.putExtra(RESPONSE, "good");
            getActivity().setResult(ListTitleFragment.REQUEST_DETAIL, intent);
        }

    }

    public static ContentFragment newInstance(String argument)
    {
        Bundle bundle = new Bundle();
        bundle.putString(ARGUMENT, argument);
        ContentFragment contentFragment = new ContentFragment();
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Random random = new Random();
        TextView tv = new TextView(getActivity());
        tv.setText(mArgument);
        tv.setGravity(Gravity.CENTER);
        tv.setBackgroundColor(Color.argb(random.nextInt(100),
                random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        return tv;
    }
}

