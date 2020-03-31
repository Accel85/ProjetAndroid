package com.example.projetandroid.requete;

import android.os.Parcel;
import android.os.Parcelable;

public class Recette implements Parcelable
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

    protected Recette(Parcel in) {
        id = in.readInt();
        title = in.readString();
        readyIn = in.readInt();
        servings = in.readInt();
    }

    public static final Creator<Recette> CREATOR = new Creator<Recette>() {
        @Override
        public Recette createFromParcel(Parcel in) {
            return new Recette(in);
        }

        @Override
        public Recette[] newArray(int size) {
            return new Recette[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeInt(readyIn);
        dest.writeInt(servings);
    }
}
