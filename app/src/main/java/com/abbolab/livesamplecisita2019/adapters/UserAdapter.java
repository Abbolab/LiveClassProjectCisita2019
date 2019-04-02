package com.abbolab.livesamplecisita2019.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abbolab.livesamplecisita2019.MainActivity;
import com.abbolab.livesamplecisita2019.R;
import com.abbolab.livesamplecisita2019.models.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<User> dataSet;

    /**
     * Costruttore del nostro Adapter personalizzato
     * @param context
     * @param dataSet
     */
    public UserAdapter(Context context, ArrayList<User> dataSet) {

        // creiamo un inflater che useremo per caricare il file XML di layout
        //come template delle celle (ViewHolder)
        this.inflater = LayoutInflater.from(context);
        // copio il riferimento della lista passata come argomento del costruttore
        this.dataSet = dataSet;

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.inflater.inflate(R.layout.user_list_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        // ottengo oggetto User da data set usando la posizione della cella corrente
        User user = this.dataSet.get(position);

        // scrivo nella textview del ViewHolder la concatenzazione tra NOME e COGNOME utente
        holder.textViewNameSurname.setText(user.userName + " " + user.surname);
        //scrivo nella textView del ViewHolder la Data sotto forma di stringa
        holder.textViewDate.setText(user.dateRegistration.toString());
        //scrivo nella texview del ViewHolder l'età dell'utente sotto forma di stringa
        holder.textViewAge.setText("Age: " + String.valueOf(user.age));

    }

    @Override
    public int getItemCount() {
        return this.dataSet.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewNameSurname;
        public TextView textViewDate;
        public TextView textViewAge;

        // costruttore
        UserViewHolder(View view) {
            super(view);

            this.textViewNameSurname = (TextView)view.findViewById(R.id.userTextViewName);
            this.textViewDate = (TextView)view.findViewById(R.id.userTextViewDate);
            this.textViewAge = (TextView)view.findViewById(R.id.userTextViewAge);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Log.d(MainActivity.K_TAG, "Cella premuta");

        }
    }
}
