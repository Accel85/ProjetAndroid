package com.example.projetandroid.requete;

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
}
