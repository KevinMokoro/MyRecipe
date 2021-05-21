package com.moringaschool.myrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesActivity extends AppCompatActivity {
    @BindView(R.id.ingredientTextView) TextView mIngredientTextView;
    @BindView(R.id.listViewRecipes) ListView mListViewRecipes;
    String[] recipes = new String[] { "brown rice","hum","hay","spaghetti","veet",
            "chickenMasala","viazi karai","uji","brown rice","mushroom","soup","yum","rum","choma","githeri"};
    String[] sources = new String[] { "Kevin Cafe", "Chef Kevin", "Taita Cafe", "BIG", "Elna", "Naden", "AIden", "Just",
    "KIki", "Jackiana", "Wakesho", "Suswa", "Box", "JUliet Towers", "Sixtus"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

        MyRecipesAdapter adapter = new MyRecipesAdapter(this, android.R.layout.simple_list_item_1, recipes, sources);
        mListViewRecipes.setAdapter(adapter);

        mListViewRecipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long l) {
                String recipe = ((TextView)view).getText().toString();
                Toast.makeText(RecipesActivity.this, recipe, Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = getIntent();
        String ingredient = intent.getStringExtra("ingredient");
        mIngredientTextView.setText("Ready Recipes That Match Your Ingredient: " + ingredient);
    }
}