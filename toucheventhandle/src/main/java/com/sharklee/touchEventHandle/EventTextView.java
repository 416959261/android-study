package com.sharklee.touchEventHandle;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;


/**
 * Created by Administrator on 2015/10/13.
 */
public class EventTextView extends TextView{

    private static final String TAG = EventTextView.class.getSimpleName();

    public EventTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent:ACTION_DOWN");
                return true;
//                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG,"onTouchEvent:ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG,"onTouchEvent:ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG,"onTouchEvent:ACTION_UP");
//                return true;
                break;
        }
        return false;
    }

}
