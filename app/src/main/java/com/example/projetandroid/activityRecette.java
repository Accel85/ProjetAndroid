package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projetandroid.requete.DetailRecette;
import com.squareup.picasso.Picasso;

public class activityRecette extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);

        Bundle extras = getIntent().getExtras();

        DetailRecette test = extras.getParcelable("detail");


        TextView titre = findViewById(R.id.tittle);
        titre.setText(test.getTitle());

        TextView temps = findViewById(R.id.temps);
        temps.setText(test.getReadyInMinutes()+" min");

        TextView nb = findViewById(R.id.nbPerso);
        nb.setText(test.getServings()+" personnes");

        TextView ingr = findViewById(R.id.ingredients);
        String ingrs = "";
        for (String in: test.getExtendedIngredients()) {
            ingrs = ingrs +"\n"+ in;
        }
        ingr.setText(ingrs);
        ingr.setMovementMethod(new ScrollingMovementMethod());


        TextView instr = findViewById(R.id.instruct);
        instr.setText(test.getAnalyzedInstructions());
        instr.setMovementMethod(new ScrollingMovementMethod());

        ImageView img = findViewById(R.id.imageView);
        Picasso.get().load(test.getImage()).into(img);

        ImageButton retour = findViewById(R.id.imageButton);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
