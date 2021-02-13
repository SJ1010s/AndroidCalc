package com.home.androidcalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingActivity extends AppCompatActivity implements ImageSet {
    ImageView imageView;
    private final String KEY_PARCEL_IMAGE = "IMAGE";
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        imageView = findViewById(R.id.image_view_main);

        initButtonStandartTheme();
        initButtonDarkTheme();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }


    private void initButtonStandartTheme() {
        RadioButton radioButton = findViewById(R.id.button_standart_theme);
        if (save.getTypeOfImage() == standartImage) {
            radioButton.setChecked(true);
        }
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save.setTypeOfImage(ImageSet.standartImage);
                recreate();
            }
        });
    }

    private void initButtonDarkTheme() {
        RadioButton radioButton = findViewById(R.id.button_dark_theme);
        if (save.getTypeOfImage() == darkImage) {
            radioButton.setChecked(true);
        }
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save.setTypeOfImage(ImageSet.darkImage);
                recreate();
            }
        });
    }

    @Override
    public void imageSet(int numberOfImage) {
        if (numberOfImage == standartImage) {
            imageView.setImageResource(R.drawable.android_calc_image);
        } else if (numberOfImage == darkImage) {
            imageView.setImageResource(R.drawable.android_calc_image_black);
        }
    }
}