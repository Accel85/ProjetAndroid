package com.example.projetandroid.requete;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;

public class Recettes
{
    private ArrayList<Recette> recettes;

    public Recettes()
    {
        recettes = new ArrayList<>();
    }

    public ArrayList<Recette> getRecettes()
    {
        return this.recettes;
    }

    public void addRecette(Recette recette)
    {
        this.recettes.add(recette);
    }

    public void removeRecette(Recette recette)
    {
        this.recettes.remove(recette);
    }

    public static Recettes init(String result)
    {
        Recettes recettes = new Recettes();

        try {
            JSONObject recipesObject = (JSONObject) new JSONTokener(result).nextValue();
            JSONArray recipesArray = recipesObject.getJSONArray("results");

            for (int i = 0; i < recipesArray.length(); i++)
            {
                JSONObject currentRecipe = recipesArray.getJSONObject(i);
                Recette recipe = new Recette(
                        currentRecipe.getInt("id"),
                        currentRecipe.getString("title"),
                        currentRecipe.getInt("readyInMinutes"),
                        currentRecipe.getInt("servings"));
                recettes.addRecette(recipe);
            }
        } catch (JSONException jsonE) {
            Log.e("JSON error", "Error with recipes init");
        }

        return recettes;
    }
}
