package cn.baway.com.a1412b_1130_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import cn.baway.com.a1412b_1130_1.R;

/**
 * Created by cj on 2016/11/30.
 */
public class ThirdActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third);
//        dog2.setOnTouchListener(new View.OnTouchListener() {
//            float x;
//            float y;
//            Matrix newMatrix = new Matrix();
//            Matrix oldMatrix = new Matrix();
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                switch (motionEvent.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        x = motionEvent.getX();
//                        y = motionEvent.getY();
//                        oldMatrix.set(dog2.getImageMatrix());
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        newMatrix.set(oldMatrix);
//                        newMatrix.setTranslate(motionEvent.getX()-x, motionEvent.getY()-y);
//                        break;
//                    case MotionEvent.ACTION_UP:
//
//                        break;
//                }
//                dog2.setImageMatrix(newMatrix);
//                return true;
//            }
//        });
    }
}
