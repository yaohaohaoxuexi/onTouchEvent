package cn.baway.com.a1412b_1130_1.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import cn.baway.com.a1412b_1130_1.application.Constants;

/**
 * Created by CJ on 2016/11/30.
 */

public class MyLinearLayout extends LinearLayout {

    private String TAG = "MyLinearLayout";
    public MyLinearLayout(Context context) {
        this(context,null);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (Constants.SHOW_ACTION_DOWN) {
                    Log.e("myMessage", " LinearLayout =========> dispatchTouchEvent " + ev.getAction());
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (Constants.SHOW_ACTION_MOVE) {
                    Log.e("myMessage", " LinearLayout =========> dispatchTouchEvent " + ev.getAction());
                }
                break;
            case MotionEvent.ACTION_UP:
                if (Constants.SHOW_ACTION_UP) {
                    Log.e("myMessage", " LinearLayout =========> dispatchTouchEvent " + ev.getAction());
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (Constants.SHOW_ACTION_DOWN) {
                    Log.e("myMessage", " LinearLayout =========> onInterceptTouchEvent " + ev.getAction());
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (Constants.SHOW_ACTION_MOVE) {
                    Log.e("myMessage", " LinearLayout =========> onInterceptTouchEvent " + ev.getAction());
                }
                break;
            case MotionEvent.ACTION_UP:
                if (Constants.SHOW_ACTION_UP) {
                    Log.e("myMessage", " LinearLayout =========> onInterceptTouchEvent " + ev.getAction());
                }
                break;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (Constants.SHOW_ACTION_DOWN) {
                    Log.e("myMessage", " LinearLayout =========> onTouchEvent " + event.getAction());
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (Constants.SHOW_ACTION_MOVE) {
                    Log.e("myMessage", " LinearLayout =========> onTouchEvent " + event.getAction());
                }
                break;
            case MotionEvent.ACTION_UP:
                if (Constants.SHOW_ACTION_UP) {
                    Log.e("myMessage", " LinearLayout =========> onTouchEvent " + event.getAction());
                }
                break;
        }
        return true;
    }
}
