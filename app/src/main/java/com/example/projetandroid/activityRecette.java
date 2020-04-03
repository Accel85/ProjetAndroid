package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projetandroid.requete.DetailRecette;
import com.example.projetandroid.requete.Recette;
import com.example.projetandroid.requete.Recettes;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class activityRecette extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);

        Bundle extras = getIntent().getExtras();

        DetailRecette test = extras.getParcelable("detail");


        TextView titre = findViewById(R.id.tittle);
        titre.setText(test.getTitle());

        TextView temps = findViewById(R.id.temps);
        temps.setText(test.getReadyInMinutes()+" min");

        TextView nb = findViewById(R.id.nbPerso);
        nb.setText(test.getServings()+" personnes");

        TextView ingr = findViewById(R.id.ingredients);
        ingr.setText(test.getExtendedIngredients().toString());

        TextView instr = findViewById(R.id.instruct);
        instr.setText(test.getAnalyzedInstructions());

        ImageView img = findViewById(R.id.imageView);
        Picasso.get().load(test.getImage()).into(img);
    }
}
