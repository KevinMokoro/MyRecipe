package com.moringaschool.myrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.myrecipe.models.SpoonacularRecipeSearchResponse;
import com.moringaschool.myrecipe.models.UsedIngredient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipesActivity extends AppCompatActivity {
    @BindView(R.id.ingredientTextView) TextView mIngredientTextView;
    @BindView(R.id.listViewRecipes) ListView mListViewRecipes;
    private Object SpoonacularRecipeSearchResponse;

    //public List<Ingredient> recipes;


  //  String[] recipes = new String[] { "brown rice","hum","hay","spaghetti","veet",
    //        "chickenMasala","viazi karai","uji","brown rice","mushroom","soup","yum","rum","choma","githeri"};
   // String[] sources = new String[] { "Kevin Cafe", "Chef Kevin", "Taita Cafe", "BIG", "Elna", "Naden", "AIden", "Just",
   // "KIki", "Jackiana", "Wakesho", "Suswa", "Box", "JUliet Towers", "Sixtus"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

    //    MyRecipesAdapter adapter = new MyRecipesAdapter(this, android.R.layout.simple_list_item_1, recipes, sources);
     //   mListViewRecipes.setAdapter(adapter);

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

        SpoonacularApi client = SpoonacularClient.getClient();
        Call<SpoonacularRecipeSearchResponse> call = client.getRecipes(ingredient);

        call.enqueue(new Callback<SpoonacularRecipeSearchResponse>() {




            @Override
            public void onResponse(Call<SpoonacularRecipeSearchResponse> call, Response<SpoonacularRecipeSearchResponse> response) {
                if(response.isSuccessful()) {

                    List<UsedIngredient> recipeList = response.body().getUsedIngredients();
                    String[] recipe = new String[recipeList.size()];
                    String[] source = new String[recipeList.size()];

                    for (int i = 0; i < recipe.length; i++){
                        recipe[i] = recipeList.get(i).getOriginalName();
                    }
                    for (int i = 0; i < source.length; i++) {
                    String title = new SpoonacularRecipeSearchResponse().getTitle();
                    source[i] = title;

                    }
                        // for (int i = 0; i < source.length; i++ ) {
                    //    SpoonacularRecipeSearchResponse title = new SpoonacularRecipeSearchResponse();
                      //  String sources = title.getTitle();
                    //    source[i] = recipeList.get(i).
                    //}




                        ArrayAdapter adapter = new MyRecipesAdapter(RecipesActivity.this, android.R.layout.simple_list_item_1, recipe, source);
                        mListViewRecipes.setAdapter(adapter);


                    }
                }



            @Override
            public void onFailure(Call<SpoonacularRecipeSearchResponse> call, Throwable t) {

            }
        });






    }
}