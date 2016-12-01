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

/**
 * Created by cj on 2016/11/30.
 */
public class SecondActivity extends Activity{
    private ImageView dog;
    private Button thirdButton;

    float x;
    float y;
    Matrix newMatrix = new Matrix();
    Matrix oldMatrix = new Matrix();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        dog = (ImageView) findViewById(R.id.dog);
        dog.setOnTouchListener(new View.OnTouchListener() {
//            float x;
//            float y;
//            Matrix newMatrix = new Matrix();
//            Matrix oldMatrix = new Matrix();
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        oldMatrix.set(dog.getImageMatrix());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        newMatrix.set(oldMatrix);
                        newMatrix.postTranslate(motionEvent.getX()-x, motionEvent.getY()-y);
                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                }
                dog.setImageMatrix(newMatrix);
                return true;
            }
        });


        thirdButton = (Button) findViewById(R.id.third);
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);

            }
        });
    }
}
