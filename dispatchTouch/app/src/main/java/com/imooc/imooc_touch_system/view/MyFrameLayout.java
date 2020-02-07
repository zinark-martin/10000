package com.imooc.imooc_touch_system.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;


public class MyFrameLayout extends FrameLayout
{
    private static final String TAG = "MyFrameLayout";

    public MyFrameLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        final int action = ev.getAction();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "dispatchTouchEvent - ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "dispatchTouchEvent - ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "dispatchTouchEvent - ACTION_UP");
                break;
        }

        return super.dispatchTouchEvent(ev);
    }

    private int mLastY ;


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        final int action = ev.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onInterceptTouchEvent - ACTION_DOWN");
                mLastY = ev.getAction();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onInterceptTouchEvent - ACTION_MOVE");
                //y移动一定距离后再进行拦截
                if(ev.getY() - mLastY >200)
                {
                    Log.e(TAG, "onInterceptTouchEvent - ACTION_MOVE - return true ");
                    return true ;
                }

                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onInterceptTouchEvent - ACTION_UP");
                break;
        }
        return super.onInterceptTouchEvent(ev);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        final int action = event.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent - ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onTouchEvent - ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent - ACTION_UP");
                break;
        }
        //return super.onTouchEvent(event);
        return true ;
    }
}
