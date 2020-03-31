package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

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
        Recettes recettes = Recettes.init(extras.getString("json"));

        ListView lv = findViewById(R.id.listV);
        RecetteAdapter ra = new RecetteAdapter(this,recettes.getRecettes());
        lv.setAdapter(ra);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent laRecette = new Intent(Resultats.this, activityRecette.class);
                laRecette.putExtra("selected", ra.getItem(position));
                laRecette.putExtra("listeRecettes", recettes.getRecettes());
                startActivityForResult(laRecette, RESULT_OK);
            }
        });

        ImageButton butRetour = findViewById(R.id.imageButton4);
        butRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
