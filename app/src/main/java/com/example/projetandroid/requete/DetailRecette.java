package com.example.projetandroid.requete;

import android.view.View;

import com.koushikdutta.ion.Ion;

public class DetailRecette {
    private String id;
    private String title;
    private String image;
    private String servings;
    private String readyInMinutes;
    private String aggregateLikes;
    private String analyzedInstructions;

    public DetailRecette(){
        this.id = null;
        this.title = null;
        this.image = null;
        this.servings = null;
        this.readyInMinutes = null;
        this.aggregateLikes = null;
        this.analyzedInstructions = null;
    }

    public void init(View v, int id){
        this.id =""+id;
//        Ion.with(v.getContext())
//                .load()

    }
}

