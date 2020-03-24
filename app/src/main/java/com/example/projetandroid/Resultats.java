package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.projetandroid.requete.Recette;
import com.example.projetandroid.requete.RecetteAdapter;
import com.example.projetandroid.requete.Recettes;

import java.util.List;

public class Resultats extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);
        Bundle extras = getIntent().getExtras();
        String[] tab = {"oui","non","peut","etre","on","est","la","oui","non","peut","etre","on","est","la","oui","non","peut","etre","on","est","la","oui","non","peut","etre","on","est","la",};
        Recettes recettes = Recettes.init(extras.getString("json"));

        ListView lv = findViewById(R.id.listV);
        RecetteAdapter ra = new RecetteAdapter(this,recettes.getRecettes());
        lv.setAdapter(ra);
    }
}
