package com.abbolab.livesamplecisita2019.fragments;

import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.abbolab.livesamplecisita2019.MainActivity;
import com.abbolab.livesamplecisita2019.R;


public class HomeFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d(MainActivity.K_TAG, "OnCreateView HomeFragment");

        return inflater.inflate(R.layout.home_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Button btnShowList = (Button) view.findViewById(R.id.btnHomeShowList);

        btnShowList.setOnClickListener(this);

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onClick(View view) {

        Log.d(MainActivity.K_TAG, "Pulsante 'Show Users' premuto!");

    }
}
