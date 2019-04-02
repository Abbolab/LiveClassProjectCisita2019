package com.abbolab.livesamplecisita2019;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.abbolab.livesamplecisita2019.fragments.HomeFragment;
import com.abbolab.livesamplecisita2019.fragments.ListFragment;

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

    /**
     * Sostituisco il fragment Home con quello List
     */
    public void goToListFragment() {

        // creo una istanza del nuovo fragment
        ListFragment listFragment = new ListFragment();

        // ottengo fragment manager per iniziare la transizione di cambio fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        //sostiuisco il precedente fragment Home con il nuovo List Fragment
        // OCCHIO AL REPLACE!!!!
        fragmentTransaction.replace(R.id.frameLayoutHome, listFragment, "LIST_FRAGMENT");

        // aggiungiamo nuovo fragment tag nello stack di navigazione per permettere
        //all'utente di poter tornare alla Home premendo il pulsante back
        fragmentTransaction.addToBackStack(listFragment.getTag());

        // finalizzo e convalido le operazioni di transizione
        fragmentTransaction.commit();

    }
}
