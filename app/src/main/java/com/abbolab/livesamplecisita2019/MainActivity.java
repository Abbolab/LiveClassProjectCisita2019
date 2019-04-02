package com.abbolab.livesamplecisita2019;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.abbolab.livesamplecisita2019.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    public static String K_TAG = "CISITA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(K_TAG, "onCreate MainActivity");

        // creo e istanzio fragment da mostrare nel Frame Layout
        createHomeFragment();
    }

    private void createHomeFragment() {

        Log.d(K_TAG, "Create Home Fragment");

        //istanziamo il nuovo fragment da mostrare
        HomeFragment homeFragment = new HomeFragment();

        // ottengo dall'activity il fragment manager per gestire i fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.frameLayoutHome, homeFragment, "HOME_FRAGMENT");

        fragmentTransaction.commit();

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
