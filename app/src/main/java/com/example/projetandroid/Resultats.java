package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projetandroid.requete.DetailRecette;
import com.example.projetandroid.requete.Recette;
import com.example.projetandroid.requete.RecetteAdapter;
import com.example.projetandroid.requete.Recettes;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

public class Resultats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);
        Bundle extras = getIntent().getExtras();
        Recettes recettes = Recettes.init(extras.getString("json"));

        ListView lv = findViewById(R.id.listV);
        RecetteAdapter ra = new RecetteAdapter(this,recettes.getRecettes());
        lv.setAdapter(ra);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ion.with(view.getContext())
                        .load("https://api.spoonacular.com/recipes/" + ra.getItem(position).getId() + "/information?apiKey=d80aa41935b94f5eb933fad13a39737e")
                        .asString()
                        .setCallback(new FutureCallback<String>() {

                            @Override
                            public void onCompleted(Exception e, String result) {
                                try {
                                    JSONObject infoObject = (JSONObject) new JSONTokener(result).nextValue();

                                    JSONArray instructArray =  infoObject.getJSONArray("extendedIngredients");
                                    ArrayList<String> listInstruct = new ArrayList();
                                    for (int i = 0; i < instructArray.length(); i++)
                                    {
                                        JSONObject currentInstruct = instructArray.getJSONObject(i);
                                        listInstruct.add(currentInstruct.getString("originalString"));
                                    }

                                    DetailRecette detail = new DetailRecette(infoObject.getString("title"),
                                            infoObject.getString("image"),
                                            infoObject.getString("servings"),
                                            infoObject.getString("readyInMinutes"),
                                            infoObject.getString("aggregateLikes"),
                                            infoObject.getString("instructions"),
                                            listInstruct);

                                    Intent laRecette = new Intent(Resultats.this, activityRecette.class);
                                    laRecette.putExtra("detail", detail);
                                    startActivityForResult(laRecette, RESULT_OK);
                                } catch (JSONException jsonE) {
                                    Log.e("JSON error", "Error with recipes init");
                                }
                            }
                        });
            }
        });

        ImageButton butRetour = findViewById(R.id.imageButton4);
        butRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
