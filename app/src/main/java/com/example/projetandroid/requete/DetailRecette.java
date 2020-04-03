package com.example.projetandroid.requete;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import com.example.projetandroid.MainActivity;
import com.example.projetandroid.Resultats;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;

public class DetailRecette implements Parcelable {

    private String title;
    private String image;
    private String servings;
    private String readyInMinutes;
    private String aggregateLikes;
    private String analyzedInstructions;
    private ArrayList<String> extendedIngredients;

    protected DetailRecette(Parcel in) {
        title = in.readString();
        image = in.readString();
        servings = in.readString();
        readyInMinutes = in.readString();
        aggregateLikes = in.readString();
        analyzedInstructions = in.readString();
        extendedIngredients = in.createStringArrayList();
    }

    public static final Creator<DetailRecette> CREATOR = new Creator<DetailRecette>() {
        @Override
        public DetailRecette createFromParcel(Parcel in) {
            return new DetailRecette(in);
        }

        @Override
        public DetailRecette[] newArray(int size) {
            return new DetailRecette[size];
        }
    };

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public void setReadyInMinutes(String readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public void setAggregateLikes(String aggregateLikes) {
        this.aggregateLikes = aggregateLikes;
    }

    public void setAnalyzedInstructions(String analyzedInstructions) {
        this.analyzedInstructions = analyzedInstructions;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getServings() {
        return servings;
    }

    public String getReadyInMinutes() {
        return readyInMinutes;
    }

    public String getAggregateLikes() {
        return aggregateLikes;
    }

    public String getAnalyzedInstructions() {
        return analyzedInstructions;
    }

    public ArrayList<String> getExtendedIngredients() {
        return extendedIngredients;
    }

    public void setExtendedIngredients(ArrayList<String> extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }

    public DetailRecette(String title, String image, String servings, String readyInMinutes, String aggregateLikes, String analyzedInstructions, ArrayList extendedIngredients) {
        this.title = title;
        this.image = image;
        this.servings = servings;
        this.readyInMinutes = readyInMinutes;
        this.aggregateLikes = aggregateLikes;
        this.analyzedInstructions = analyzedInstructions;
        this.extendedIngredients = extendedIngredients ;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(image);
        dest.writeString(servings);
        dest.writeString(readyInMinutes);
        dest.writeString(aggregateLikes);
        dest.writeString(analyzedInstructions);
        dest.writeStringList(extendedIngredients);
    }
}

