package com.example.mathguru;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MathTest extends AppCompatActivity {

    private TextView mSolveExample, mScorePoints, mHealthPoint;
    private int mCount;
    private int mLife = 3;
    private Button FirstButton, SecondButton, ThirdButton, FourthButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_test);

        mSolveExample = findViewById(R.id.SolveExample);
        mScorePoints = findViewById(R.id.ScorePoints);
        mHealthPoint = findViewById(R.id.HealthPoint);
        mScorePoints.setText("Текущий счет: " + mCount);
        mHealthPoint.setText("Жизни: " + mLife);

        FirstButton = findViewById(R.id.FirstAnswer);
        SecondButton = findViewById(R.id.SecondAnswer);
        ThirdButton = findViewById(R.id.ThirdAnswer);
        FourthButton = findViewById(R.id.FourthAnswer);



        /*FirstButton.setOnClickListener(v->{
            if(FirstButton.getText().to == MathQuestion())
        });

         */


    }

    /*public int MathQuestion(){
        Random rd = new Random();
        int a = rd.nextInt((30) + 1);
        int b = rd.nextInt((30) + 1);
        int ans = 0;
        char oper = '0';
        switch (rd.nextInt(3)) {
            case 0:
                oper = '+';
                ans = a + b;
                break;
            case 1:
                oper = '*';
                ans = a * b;
                break;
            case 2:
                oper = '-';
                ans = a - b;
                break;
        }

        mSolveExample.setText(a + " " + oper + " " + b);
        return ans;
    }

     */






}