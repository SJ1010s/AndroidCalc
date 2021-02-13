package com.home.androidcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingActivity extends AppCompatActivity implements ImageSet {
    ImageView imageView;
    SharedPreferences getSetting;
    SharedPreferences.Editor editSetting;
    private final int STANDART_IMAGE = 1;
    private final int DARK_IMAGE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSetting = getSharedPreferences(KEY_SETTING, MODE_PRIVATE);
        editSetting = getSetting.edit();

        imageView = findViewById(R.id.image_view_main);
        imageSet(getSettingImage());
        initButtonStandartTheme();
        initButtonDarkTheme();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    private void initButtonStandartTheme() {
        RadioButton radioButton = findViewById(R.id.button_standart_theme);
        if (getSettingImage() == STANDART_IMAGE) {
            radioButton.setChecked(true);
        }
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editSetting.putInt(KEY_IMAGE, STANDART_IMAGE);
                editSetting.commit();
                imageSet(getSettingImage());
            }
        });
    }

    private void initButtonDarkTheme() {
        RadioButton radioButton = findViewById(R.id.button_dark_theme);
        if (getSettingImage() == DARK_IMAGE) {
            radioButton.setChecked(true);
        }
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editSetting.putInt(KEY_IMAGE, DARK_IMAGE);
                editSetting.commit();
                imageSet(getSettingImage());
            }
        });
    }

    @Override
    public int getSettingImage() {
        return getSetting.getInt(KEY_IMAGE, STANDART_IMAGE);
    }

    @Override
    public void imageSet(int numberOfImage) {
        if (numberOfImage == STANDART_IMAGE) {
            imageView.setImageResource(R.drawable.android_calc_image);
        } else if (numberOfImage == DARK_IMAGE) {
            imageView.setImageResource(R.drawable.android_calc_image_black);
        }
    }
}