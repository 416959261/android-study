package com.sharklee.viewDragHelper;


import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by zhy on 15/6/3.
 */
public class VDHLayout extends LinearLayout
{
    private ViewDragHelper mDragger;

    private View mDragView;

    public VDHLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        mDragger = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback()
        {
            @Override
            public boolean tryCaptureView(View child, int pointerId)
            {
                mDragView = child;
                return true;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx)
            {
                final int leftBound = getPaddingLeft();
                final int rightBound = getWidth() - mDragView.getWidth() - leftBound;

                final int newLeft = Math.min(Math.max(left, leftBound), rightBound);

                return newLeft;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy)
            {
                final int topReboud = getPaddingTop();
                final int bottomBound = getHeight() - mDragView.getHeight() -topReboud;

                final int newTop = Math.min(Math.max(top, topReboud), bottomBound);

                return newTop;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event)
    {
        return mDragger.shouldInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        mDragger.processTouchEvent(event);
        return true;
    }
}
