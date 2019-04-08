package com.abbolab.livesamplecisita2019.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abbolab.livesamplecisita2019.MainActivity;
import com.abbolab.livesamplecisita2019.R;
import com.abbolab.livesamplecisita2019.adapters.UserAdapter;
import com.abbolab.livesamplecisita2019.models.User;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;

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
        /*
        // popolo data set con dati statici
        for(int index = 0; index < 20; index++) {
            users.add(new User());
        }*/
        //Utente test 1
        User user1 = new User();
        user1.userName = "Francesco";
        user1.surname = "Abbo";
        user1.dateRegistration = new Date();
        user1.age = 31;

        //Utente test 2
        User user2 = new User();
        user2.userName = "Marco";
        user2.surname = "Rossi";
        user2.dateRegistration = new Date();
        user2.age = 40;

        //Utente test 3
        User user3 = new User();
        user3.userName = "Beatrice";
        user3.surname = "Modica";
        user3.dateRegistration = new Date();
        user3.age = 26;

        users.add(user1);
        users.add(user2);
        users.add(user3);

        // istanzio adapter per il bind dei dati
        UserAdapter userAdapter = new UserAdapter(getActivity(), users);

        recyclerView.setAdapter(userAdapter);

        // eseguo request per ottenere lista utenti
        dowloadUserData();
    }

    /**
     * Scarico e renderizzo dati ottenuti da Web-services
     */
    private void dowloadUserData() {

        Log.d(MainActivity.K_TAG, "ListFragment dowloadUserData");

        // istanzio client HTTTP per svolgere le request
        AsyncHttpClient httpClient = new AsyncHttpClient();
        // eseguo chiamata HTTP tramite metodo GET all'URL del mio end-point users
        httpClient.get("https://private-241152-cisitatest.apiary-mock.com/users", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d(MainActivity.K_TAG, "Responce onSuccess!!!");

                try {
                    // converto array di byte in string UTF-8
                    String jsonString = new String(responseBody, "utf-8");
                    //Log.d(MainActivity.K_TAG, "JSON string responce: " + jsonString);
                    // serializzo stringa in oggetto JSON
                    JSONObject jsonObject = new JSONObject(jsonString);
                    Log.d(MainActivity.K_TAG, "JSON Object responce: " + jsonObject.toString());
                    // inizio il parse - ottengo array di utenti da oggetto JSON
                    JSONArray usersArray = jsonObject.getJSONArray("users");
                    Log.d(MainActivity.K_TAG, "JSON Array users count: " + usersArray.length());
                    // ciclare gli oggetti contenuti nell'array per trasformarmi in oggetti Java User
                    for(int index=0; index < usersArray.length(); index++) {
                        // otttengo utente tramite rappresentazione JSON
                        JSONObject userJSON = usersArray.getJSONObject(index);
                        //instanziare il mio oggetto Java User
                        User user = new User();
                        // vado a mappare i campi del JSON nelle proprietà dell'oggetto User
                        user.userName = userJSON.getString("name");
                        user.surname = userJSON.getString("surname");
                        user.age = userJSON.getInt("age");
                        // conversione di Data da stringa a oggetto Date
                        String dateRegistration = userJSON.getString("dateRegistration");
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-mm HH:mm", Locale.ITALIAN);
                        user.dateRegistration = dateFormat.parse(dateRegistration);
                    }

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e(MainActivity.K_TAG, "Responce onFailure!!! " + error.getLocalizedMessage());
            }
        });

    }
}
