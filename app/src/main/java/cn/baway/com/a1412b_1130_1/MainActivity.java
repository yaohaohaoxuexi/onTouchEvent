package cn.baway.com.a1412b_1130_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import cn.baway.com.a1412b_1130_1.view.PieView;
import cn.baway.com.a1412b_1130_1.application.Constants;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button fourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PieView pieView = (PieView) findViewById(R.id.pieView);
        pieView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("myMessage","OnClickListener");
            }
        });
        button = (Button) findViewById(R.id.second);
        fourth = (Button) findViewById(R.id.fourth);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FourthActivity.class);
                startActivity(intent);
            }
        });
        pieView.setPieDatas(null);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (Constants.SHOW_ACTION_DOWN) {
                    Log.e("myMessage", " Activity =========> dispatchTouchEvent " + ev.getAction());
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (Constants.SHOW_ACTION_MOVE) {
                    Log.e("myMessage", " Activity =========> dispatchTouchEvent " + ev.getAction());
                }
                break;
            case MotionEvent.ACTION_UP:
                if (Constants.SHOW_ACTION_UP) {
                    Log.e("myMessage", " Activity =========> dispatchTouchEvent " + ev.getAction());
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
                    Log.e("myMessage", " Activity =========> onTouchEvent " + event.getAction());
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (Constants.SHOW_ACTION_MOVE) {
                    Log.e("myMessage", " Activity =========> onTouchEvent " + event.getAction());
                }
                break;
            case MotionEvent.ACTION_UP:
                if (Constants.SHOW_ACTION_UP) {
                    Log.e("myMessage", " Activity =========> onTouchEvent " + event.getAction());
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
