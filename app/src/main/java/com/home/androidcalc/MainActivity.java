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

    private TextView textIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImage();
        keyboardOff();

    }


    private void keyboardOff () {
        EditText editText = findViewById(R.id.textIn);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            editText.setShowSoftInputOnFocus(false);
        } else {
            editText.setTextIsSelectable(true);
        }
    }
    private void initImage() {
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.android_calc_image));
    }

}