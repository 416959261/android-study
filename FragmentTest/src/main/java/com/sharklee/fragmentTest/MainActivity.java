package com.sharklee.fragmentTest;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;


public class MainActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    private Fragment two;
    private Fragment three;
    private Handler handler = new Handler();

    private int whichFragmentToShow = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(savedInstanceState == null){
            two = new FragmentTwo();
            three = new FragmentThree();
            transaction.add(R.id.fragmentTwoContainer, three,"three");
            transaction.hide(three);
            transaction.add(R.id.fragmentTwoContainer, two,"two");
            transaction.commit();
            whichFragmentToShow = 2;
        }else{
            whichFragmentToShow = savedInstanceState.getInt("toShow");
            if(whichFragmentToShow == 2){
                switchFragment(R.id.gunlun);
            }

            if(whichFragmentToShow == 3){
                switchFragment(R.id.putong);
            }
        }
        findViewById(R.id.gunlun).setOnClickListener(this);
        findViewById(R.id.putong).setOnClickListener(this);

//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                three = new FragmentThree();
//                transaction.hide(two);
//                transaction.add(R.id.fragmentTwoContainer,three);
//                transaction.addToBackStack(null);
//                transaction.commit();
//            }
//        },3000);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "onSaveInstanceState");
        outState.putInt("toShow",whichFragmentToShow);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, "onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG,"onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG,"onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG,"onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG,"onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switchFragment(id);
    }

    private void switchFragment(int id){
        FragmentManager fragmentManager = getFragmentManager();
        if(id == R.id.gunlun){
//            if(two!=null){
//                if(two.isHidden()){
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    if(three!=null){
                        transaction.hide(three);
                    }
                    transaction.show(two);
                    transaction.commit();
                    whichFragmentToShow = 2;
//                }
//            }else{
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                if(three!=null){
//                    transaction.hide(three);
//                }
//                two = new FragmentTwo();
//                transaction.add(R.id.fragmentTwoContainer,two);
//                transaction.commit();
//            }
        }

        if(id == R.id.putong){
//            if(three!=null){
//                if(three.isHidden()){
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    if(two!=null){
                        transaction.hide(two);
                    }
                    transaction.show(three);
                    transaction.commit();
                    whichFragmentToShow = 3;
//                }
//            }else{
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                if(two!=null){
//                    transaction.hide(two);
//                }
//                three = new FragmentTwo();
//                transaction.add(R.id.fragmentTwoContainer, three);
//                transaction.commit();
//            }
        }
    }
}
