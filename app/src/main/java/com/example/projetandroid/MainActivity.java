package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{
    private EditText infoRecherche;
    private Spinner genreSpinner;
    private SeekBar nombreSeekBar;
    private Button lancerRecherche;

    private String[] genres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoRecherche = findViewById(R.id.infoRecherche);
        genreSpinner = findViewById(R.id.genreSpinner);
        nombreSeekBar = findViewById(R.id.nombreSeekBar);
        nombreSeekBar.setMax(10);
        lancerRecherche = findViewById(R.id.lancerRecherche);

        genres = new String[]{"African", "American", "British", "Cajun", "Caribbean", "Chinese",
                "Eastern European", "European", "French", "German", "Greek", "Indian", "Irish",
                "Italian", "Japanese", "Jewish", "Korean", "Latin American", "Mediterranean",
                "Mexican", "Middle Eastern", "Nordic", "Southern", "Spanish", "Thai", "Vietnamese"};

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, genres);
        genreSpinner.setAdapter(spinnerArrayAdapter);


        /*
        lancerRecherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent
            }
        });*/
    }
}
