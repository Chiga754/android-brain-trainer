package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTimer;
    private TextView textViewExample;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    private int maxNunInExample = 10;
    private int minNunInExample = 1;
    private int rightAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewTimer = findViewById(R.id.textViewTimer);
        textViewExample = findViewById(R.id.textViewExample);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);


        BtnOnClickListener listener = new BtnOnClickListener();
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        createRandomExample();


        CountDownTimer timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                int seconds = (int) l / 1000;
                textViewTimer.setText(String.valueOf(seconds));
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Время вышло", Toast.LENGTH_SHORT).show();
            }
        };
        timer.start();
    }

    private void createRandomExample() {
        int a = (int) (Math.random() * ((maxNunInExample - minNunInExample) + 1)) + minNunInExample;
        int b = (int) (Math.random() * ((maxNunInExample - minNunInExample) + 1)) + minNunInExample;
        rightAnswer = a * b;
        textViewExample.setText(a + " * " + b);
        int random = (int) (Math.random() * ((4 - 1) + 1)) + 1;
        switch (random) {
            case 1 :
                btn1.setText(String.valueOf(rightAnswer));
                break;
            case 2 :
                btn2.setText(String.valueOf(rightAnswer));
                break;
            case 3 :
                btn3.setText(String.valueOf(rightAnswer));
                break;
            case 4 :
                btn4.setText(String.valueOf(rightAnswer));
                break;
        }
    }
}