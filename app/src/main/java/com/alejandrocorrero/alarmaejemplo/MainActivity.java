package com.alejandrocorrero.alarmaejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Alarm alarm = Alarm.getInstance(this);
            alarm.turnOn(this);
    }
}
