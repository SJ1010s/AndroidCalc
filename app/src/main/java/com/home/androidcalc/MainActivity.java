package com.home.androidcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText textIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImage();
        initTextIn();
        keyboardOff();
        initButtonOne();
        initButtonTwo();
        initButtonThree();
        initButtonFour();
        initButtonFive();
        initButtonSix();
        initButtonSeven();
        initButtonEight();
        initButtonNine();
        initButtonZero();

    }

    private void initTextIn(){
        textIn = findViewById(R.id.textIn);
    }

    private void initImage() {
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.android_calc_image));
    }

    private void keyboardOff() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textIn.setShowSoftInputOnFocus(false);
        } else {
            textIn.setTextIsSelectable(true);
        }
    }

    private void initButtonOne(){
        Button buttonOne = findViewById(R.id.ButtonOne);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("1");
            }
        });
    }

    private void initButtonTwo(){
        Button buttonOne = findViewById(R.id.ButtonTwo);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("2");
            }
        });
    }

    private void initButtonThree(){
        Button buttonOne = findViewById(R.id.ButtonThree);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("3");
            }
        });
    }

    private void initButtonFour(){
        Button buttonOne = findViewById(R.id.ButtonFour);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("4");
            }
        });
    }

    private void initButtonFive(){
        Button buttonOne = findViewById(R.id.ButtonFive);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("5");
            }
        });
    }

    private void initButtonSix(){
        Button buttonOne = findViewById(R.id.ButtonSix);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("6");
            }
        });
    }

    private void initButtonSeven(){
        Button buttonOne = findViewById(R.id.ButtonSeven);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("7");
            }
        });
    }

    private void initButtonEight(){
        Button buttonOne = findViewById(R.id.ButtonEight);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("8");
            }
        });
    }

    private void initButtonNine(){
        Button buttonOne = findViewById(R.id.ButtonNine);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("9");
            }
        });
    }

    private void initButtonZero(){
        Button buttonOne = findViewById(R.id.ButtonZero);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("0");
            }
        });
    }
}