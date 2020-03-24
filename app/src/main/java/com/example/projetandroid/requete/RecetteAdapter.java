package com.example.projetandroid.requete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.projetandroid.R;

import java.security.PublicKey;
import java.util.ArrayList;

public class RecetteAdapter extends ArrayAdapter<Recette> {
    public RecetteAdapter(Context context, ArrayList<Recette> items) {
        super(context, R.layout.ligne_layout, items);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row;
// instanciation d’un View correspondant à notre fichier de layout
        LayoutInflater inflater = LayoutInflater.from(getContext());
        row = inflater.inflate(R.layout.ligne_layout, parent, false);
// personnalisation de la vue
        Recette r = getItem(position);
        TextView titre = (TextView)row.findViewById(R.id.titre);
        titre.setText(r.getTitle());
        TextView pers = (TextView)row.findViewById(R.id.personnes);
        pers.setText("for: "+r.getServings());
        TextView temps = (TextView)row.findViewById(R.id.temps);
        pers.setText(""+r.getReadyIn() +"'");
        return(row);
    }
}
