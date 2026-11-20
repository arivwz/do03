package com.example.do03;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int start_x = 0; // координата X при нажатии
    int end_x = 0;   // координата X при отпуске

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP: // если нажатие
                start_x = (int) event.getX(); // определяем координату X
                break;
            case MotionEvent.ACTION_DOWN: // если отжатие
                end_x = (int) event.getX(); // определяем координату X
                break;
        }

        if (start_x != 0 && end_x != 0) {
            if (start_x > end_x) {
                // свайп влево
                setContentView(R.layout.activity_main);
            } else if (start_x < end_x) {
                // свайп вправо
                setContentView(R.layout.regin);
            }

            start_x = 0; // обнуляем координаты
            end_x = 0;   // обнуляем координаты
        }

        return false;
    }
}