package cn.baway.com.a1412b_1130_1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import cn.baway.com.a1412b_1130_1.application.Constants;
import cn.baway.com.a1412b_1130_1.modle.PieData;

/**
 * Created by CJ on 2016/11/30.
 */

public class PieView extends View {
    private int mWidth;
    private int mHeight;
    private RectF mRectF;
    private Paint mPaint;
    private Paint mPaintRect;
    private int mStartAngle;
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080, 0xFFE6B800, 0xFF7CFC00};
    private ArrayList<PieData> pieDatas;

    private String TAG = "View";

    public PieView(Context context) {
        this(context,null);
    }

    public PieView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRectF = new RectF(0,0,500,500);
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);

        mPaintRect = new Paint();
        mPaintRect.setColor(Color.MAGENTA);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.translate(mWidth / 2, mHeight / 2); // 将画布坐标原点移动到中心位置
       // canvas.drawColor(Color.BLUE);
        canvas.drawRect(mRectF,mPaintRect);
        for (int i = 0; i < 6; i++) {
            canvas.drawArc(mRectF,mStartAngle,60,true,mPaint);
            mStartAngle += 60;
            mPaint.setColor(mColors[i]);
        }
        //canvas.drawArc(mRectF,50,50,true,mPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    public void setPieDatas(ArrayList<PieData> pieDatas) {
        this.pieDatas = pieDatas;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (Constants.SHOW_ACTION_DOWN) {
                    Log.e("myMessage", " View =========> dispatchTouchEvent " + ev.getAction());
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (Constants.SHOW_ACTION_MOVE) {
                    Log.e("myMessage", " View =========> dispatchTouchEvent " + ev.getAction());
                }
                break;
            case MotionEvent.ACTION_UP:
                if (Constants.SHOW_ACTION_UP) {
                    Log.e("myMessage", " View =========> dispatchTouchEvent " + ev.getAction());
                }
                break;
        }

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (Constants.SHOW_ACTION_DOWN) {
                    Log.e("myMessage", " View =========> onTouchEvent " + event.getAction());
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (Constants.SHOW_ACTION_MOVE) {
                    Log.e("myMessage", " View =========> onTouchEvent " + event.getAction());
                }
                break;
            case MotionEvent.ACTION_UP:
                if (Constants.SHOW_ACTION_UP) {
                    Log.e("myMessage", " View =========> onTouchEvent " + event.getAction());
                }
                break;
        }
        return false;
    }
}
