package com.example.projetandroid.requete;
//
public class Recette
{
    private int id;
    private String title;
    private int readyIn;
    private int servings;

    public Recette(int id, String title, int readyIn, int servings)
    {
        this.id = id;
        this.title = title;
        this.readyIn = readyIn;
        this.servings = servings;
    }

    public int getId()
    {
        return this.id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public int getReadyIn()
    {
        return this.readyIn;
    }

    public int getServings()
    {
        return this.servings;
    }
}
