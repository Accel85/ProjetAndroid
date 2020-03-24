package com.example.projetandroid.requete;

public class Recette
{
    private String id;
    private String title;
    private String readyIn;
    private String servings;

    public Recette(String id, String title, String readyIn, String servings)
    {
        this.id = id;
        this.title = title;
        this.readyIn = readyIn;
        this.servings = servings;
    }

    public String getId()
    {
        return this.id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getReadyIn()
    {
        return this.readyIn;
    }

    public String getServings()
    {
        return this.servings;
    }
}
