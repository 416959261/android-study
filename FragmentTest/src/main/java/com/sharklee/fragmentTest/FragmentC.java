package com.sharklee.fragmentTest;


        import android.app.Fragment;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.Toast;

public class FragmentC extends Fragment implements OnClickListener
{

    private static final String TAG = "FragmentC";

    private Button mBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Log.i(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.layout_fragmentc, container, false);
        mBtn = (Button) view.findViewById(R.id.buttonInFragmentC);
        mBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
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
        Toast.makeText(getActivity(), " i am a btn in Fragment three",
                Toast.LENGTH_SHORT).show();
    }

}

