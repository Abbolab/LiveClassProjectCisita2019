package com.abbolab.livesamplecisita2019.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abbolab.livesamplecisita2019.R;
import com.abbolab.livesamplecisita2019.adapters.UserAdapter;
import com.abbolab.livesamplecisita2019.models.User;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.usersRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // definisco e istanzio data set di Users
        ArrayList<User> users = new ArrayList<User>();
        // popolo data set con dati statici
        for(int index = 0; index < 20; index++) {
            users.add(new User());
        }

        // istanzio adapter per il bind dei dati
        UserAdapter userAdapter = new UserAdapter(getActivity(), users);

        recyclerView.setAdapter(userAdapter);

    }
}
