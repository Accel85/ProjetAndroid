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

        String[] tab = {"oui","non","peut","etre","on","est","la","oui","non","peut","etre","on","est","la","oui","non","peut","etre","on","est","la","oui","non","peut","etre","on","est","la",};
        Recettes recettes = Recettes.init("{\"results\":[{\"id\":215435,\"title\":\"Three-Cheese Pizza (For Cheese Lovers)\",\"readyInMinutes\":45,\"servings\":8,\"image\":\"three-cheese-pizza-for-cheese-lovers-215435.jpg\",\"imageUrls\":[\"three-cheese-pizza-for-cheese-lovers-215435.jpg\"]},{\"id\":323420,\"title\":\"Grilled Cheese\",\"readyInMinutes\":55,\"servings\":4,\"image\":\"grilled-cheese-323420.jpeg\",\"imageUrls\":[\"grilled-cheese-323420.jpeg\"]}],\"baseUri\":\"https://spoonacular.com/recipeImages/\",\"offset\":0,\"number\":2,\"totalResults\":855,\"processingTimeMs\":454,\"expires\":1585130814437,\"isStale\":false}");

        ListView lv = findViewById(R.id.listV);
        RecetteAdapter ra = new RecetteAdapter(this,recettes.getRecettes());
        lv.setAdapter(ra);
    }
}
