package com.moringaschool.myrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesActivity extends AppCompatActivity {
    @BindView(R.id.ingredientTextView) TextView mIngredientTextView;
    @BindView(R.id.listViewRecipes) ListView mListViewRecipes;
    String[] recipes = new String[] { "brown rice","hum","hay","spaghetti","veet",
            "chickenMasala","viazi karai","uji","brown rice","mushroom","soup","yum","rum","choma","githeri"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, recipes);
        mListViewRecipes.setAdapter(adapter);

        Intent intent = getIntent();
        String ingredient = intent.getStringExtra("ingredient");
        mIngredientTextView.setText("Ready Recipes That Match Your Ingredient: " + ingredient);


    }


}