package com.home.androidcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ImageSet {

    private static EditText textIn;
    BaseInputConnection textFieldInputConnection;
    ImageView imageView;
    SharedPreferences getSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSetting = getSharedPreferences(KEY_SETTING, MODE_PRIVATE);

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
        initButtonPoint();
        initButtonPlus();
        initButtonMinus();
        initButtonMulti();
        initButtonDiv();
        initButtonBack();
        initButtonOpenS();
        initButtonCloseS();
        initSettingButton();
    }


    private void initTextIn() {
        textIn = findViewById(R.id.textIn);
        textFieldInputConnection = new BaseInputConnection(textIn, true);
    }

    public EditText getTextIn() {
        return textIn;
    }

    private void initImage() {
        imageView = findViewById(R.id.image_view_main);
        imageSet(getSettingImage());
    }

    @Override
    public void imageSet(int numberOfImage) {
        if (numberOfImage == STANDART_IMAGE) {
            imageView.setImageResource(R.drawable.android_calc_image);
        } else if (numberOfImage == DARK_IMAGE) {
            imageView.setImageResource(R.drawable.android_calc_image_black);
        }
    }

    @Override
    public int getSettingImage() {
        return getSetting.getInt(KEY_IMAGE, STANDART_IMAGE);
    }

    private void keyboardOff() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textIn.setShowSoftInputOnFocus(false);
        } else {
            textIn.setTextIsSelectable(true);
        }
    }

    private void initButtonOne() {
        Button button = findViewById(R.id.ButtonOne);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("1");
            }
        });
    }

    private void initButtonTwo() {
        Button button = findViewById(R.id.ButtonTwo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("2");
            }
        });
    }

    private void initButtonThree() {
        Button button = findViewById(R.id.ButtonThree);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("3");
            }
        });
    }

    private void initButtonFour() {
        Button button = findViewById(R.id.ButtonFour);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("4");
            }
        });
    }

    private void initButtonFive() {
        Button button = findViewById(R.id.ButtonFive);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("5");
            }
        });
    }

    private void initButtonSix() {
        Button button = findViewById(R.id.ButtonSix);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("6");
            }
        });
    }

    private void initButtonSeven() {
        Button button = findViewById(R.id.ButtonSeven);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("7");
            }
        });
    }

    private void initButtonEight() {
        Button button = findViewById(R.id.ButtonEight);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("8");
            }
        });
    }

    private void initButtonNine() {
        Button button = findViewById(R.id.ButtonNine);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("9");
            }
        });
    }

    private void initButtonZero() {
        Button button = findViewById(R.id.ButtonZero);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("0");
            }
        });
    }

    private void initButtonPoint() {
        Button button = findViewById(R.id.ButtonPoint);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append(".");
            }
        });
    }

    private void initButtonPlus() {
        Button button = findViewById(R.id.ButtonPlus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("+");
            }
        });
    }

    private void initButtonMinus() {
        Button button = findViewById(R.id.ButtonMinus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("-");
            }
        });
    }

    private void initButtonMulti() {
        Button button = findViewById(R.id.ButtonMulti);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("*");
            }
        });
    }

    private void initButtonDiv() {
        Button button = findViewById(R.id.ButtonDiv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("/");
            }
        });
    }

    private void initButtonOpenS() {
        Button button = findViewById(R.id.ButtonOpenS);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append("(");
            }
        });
    }


    private void initButtonCloseS() {
        Button button = findViewById(R.id.ButtonCloseS);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIn.append(")");
            }
        });
    }

    private void initButtonBack() {
        Button button = findViewById(R.id.ButtonBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
            }
        });
    }

    private void initSettingButton() {
        Button button = findViewById(R.id.button_setting);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startActivitySetting = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(startActivitySetting);
            }
        });
    }
}