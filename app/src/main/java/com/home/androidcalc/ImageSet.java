package com.home.androidcalc;

public interface ImageSet {
    int STANDART_IMAGE = 1;
    int DARK_IMAGE = 2;
    String KEY_SETTING = "SETTING";
    String KEY_IMAGE = "IMAGE";
    void imageSet(int numberOfImage);
    int getSettingImage();
}
