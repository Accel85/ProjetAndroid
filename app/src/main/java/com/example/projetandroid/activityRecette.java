package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.projetandroid.requete.Recette;
import com.example.projetandroid.requete.Recettes;

import java.util.ArrayList;

public class activityRecette extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);

        Bundle extras = getIntent().getExtras();

        Recette test = extras.getParcelable("selected");

        ArrayList list = extras.getParcelableArrayList("listeRecettes");


        TextView titre = findViewById(R.id.tittle);
        titre.setText(test.getTitle());

        TextView temps = findViewById(R.id.temps);
        temps.setText(test.getReadyIn()+"");

        TextView nb = findViewById(R.id.nbPerso);
        nb.setText(test.getServings()+"");
    }
}
