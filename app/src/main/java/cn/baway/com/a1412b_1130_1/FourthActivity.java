package cn.baway.com.a1412b_1130_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.FloatMath;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import cn.baway.com.a1412b_1130_1.application.Constants;
import cn.baway.com.a1412b_1130_1.view.PieView;

public class FourthActivity extends Activity implements View.OnTouchListener {
    /**
     * Called when the activity is first created.
     */

    //放大缩小
    Matrix matrix = new Matrix();
    Matrix savedMatrix = new Matrix();

    PointF start = new PointF();
    PointF mid = new PointF();
    double oldDist;

    private ImageView myImageView;

    //模式
    static final int NONE = 0;
    static final int DRAG = 1;
    static final int ZOOM = 2;
    int mode = NONE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        myImageView = (ImageView) findViewById(R.id.dog);
        myImageView.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ImageView myImageView = (ImageView) v;
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            //设置拖拉模式
            case MotionEvent.ACTION_DOWN:
                matrix.set(myImageView.getImageMatrix());
                savedMatrix.set(matrix);
                start.set(event.getX(), event.getY());
                mode = DRAG;
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                mode = NONE;
                break;

            //设置多点触摸模式
            case MotionEvent.ACTION_POINTER_DOWN:
                oldDist = spacing(event);
                if (oldDist > 10f) {
                    savedMatrix.set(matrix);
                    midPoint(mid, event);
                    mode = ZOOM;
                }
                break;

            case MotionEvent.ACTION_MOVE:
                if (mode == DRAG) {
                    //若为DRAG模式，则点击移动图片
                    matrix.set(savedMatrix);
                    matrix.postTranslate(event.getX() - start.x, event.getY() - start.y);
                } else if (mode == ZOOM) {
                    //若为ZOOM模式，则点击触摸缩放
                    double newDist = spacing(event);
                    if (newDist > 10f) {
                        matrix.set(savedMatrix);
                        double scale = newDist / oldDist;
                        //设置硕放比例和图片的中点位置
                        matrix.postScale((float) scale, (float) scale, mid.x, mid.y);
                    }
                }
                break;
        }
        myImageView.setImageMatrix(matrix);
        return true;
    }

    //计算移动距离
    private double spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return Math.sqrt(x * x + y * y);
    }

    //计算中点位置
    private void midPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }
}
