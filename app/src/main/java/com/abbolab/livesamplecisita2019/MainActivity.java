package com.abbolab.livesamplecisita2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static String K_TAG = "CISITA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(K_TAG, "onCreate MainActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(K_TAG, "onResume MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(K_TAG, "onDestroy MainActivity");
    }
}
