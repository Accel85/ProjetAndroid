package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity
{
    public static String key = "d80aa41935b94f5eb933fad13a39737e";

    private EditText infoRecherche;
    private Spinner genreSpinner;
    private SeekBar nombreSeekBar;
    private CheckBox limiteNombre;
    private Button lancerRecherche;

    private String[] genres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoRecherche = findViewById(R.id.infoRecherche);
        genreSpinner = findViewById(R.id.genreSpinner);
        nombreSeekBar = findViewById(R.id.nombreSeekBar);
        nombreSeekBar.setMax(20);
        limiteNombre = findViewById(R.id.checkNumber);
        lancerRecherche = findViewById(R.id.lancerRecherche);

        genres = new String[]{"African", "American", "British", "Cajun", "Caribbean", "Chinese",
                "Eastern European", "European", "French", "German", "Greek", "Indian", "Irish",
                "Italian", "Japanese", "Jewish", "Korean", "Latin American", "Mediterranean",
                "Mexican", "Middle Eastern", "Nordic", "Southern", "Spanish", "Thai", "Vietnamese"};

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, genres);
        genreSpinner.setAdapter(spinnerArrayAdapter);

        lancerRecherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = infoRecherche.getText().toString();
                String number = "100";

                if (!limiteNombre.isChecked())
                    number = "" + nombreSeekBar.getProgress();

                System.out.println(number);
                Ion.with(v.getContext())
                    .load("https://api.spoonacular.com/recipes/search?query=" + query + "&number=" + number + "&apiKey=" + key)
                    .asString()
                    .setCallback(new FutureCallback<String>() {
                        @Override
                        public void onCompleted(Exception e, String result) {
                            Intent resultats = new Intent(MainActivity.this, Resultats.class);
                            resultats.putExtra("json", result);
                            startActivity(resultats);
                        }
                    });
            }
        });
    }
}
