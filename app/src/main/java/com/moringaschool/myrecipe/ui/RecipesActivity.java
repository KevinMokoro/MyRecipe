package com.moringaschool.myrecipe.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.myrecipe.models.EdamamRecipeSearchResponse;
import com.moringaschool.myrecipe.models.Hit;
import com.moringaschool.myrecipe.R;
import com.moringaschool.myrecipe.adapters.RecipeListAdapter;
import com.moringaschool.myrecipe.network.EdamamApi;
import com.moringaschool.myrecipe.network.EdamamClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.moringaschool.myrecipe.Constants.EDAMAM_API_KEY;
import static com.moringaschool.myrecipe.Constants.EDAMAM_ID;

public class RecipesActivity extends AppCompatActivity {
    private static final String TAG = RecipesActivity.class.getSimpleName();
    @BindView(R.id.ingredientTextView) TextView mIngredientTextView;
  //  @BindView(R.id.listViewRecipes) ListView mListViewRecipes;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    private RecipeListAdapter mAdapter;
    public List<Hit>  recipes;


    //public List<> recipes;


  private void showFailureMessage() {
      mErrorTextView.setText("Something went wrong. Please check your internet connection and try again." );
      mErrorTextView.setVisibility(View.VISIBLE);
  }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Try agin later.");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showRecipes() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressbar() {
        mProgressBar.setVisibility(View.GONE);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

    //    MyRecipesAdapter adapter = new MyRecipesAdapter(this, android.R.layout.simple_list_item_1, recipes, sources);
     //   mListViewRecipes.setAdapter(adapter);

   //     mListViewRecipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
     //       @Override
     //       public void onItemClick(AdapterView<?>parent, View view, int position, long l) {
      //          String recipe = ((TextView)view).getText().toString();
       //         Toast.makeText(RecipesActivity.this, recipe, Toast.LENGTH_LONG).show();
       //     }
      //  });
        Intent intent = getIntent();
        String ingredient = intent.getStringExtra("ingredient");
        mIngredientTextView.setText("Ready Recipes That Match Your Ingredient: " + ingredient);

        EdamamApi client = EdamamClient.getClient();
        Call<EdamamRecipeSearchResponse> call = client.getRecipes("public",ingredient,EDAMAM_ID, EDAMAM_API_KEY);

        call.enqueue(new Callback<EdamamRecipeSearchResponse>() {
            @Override
            public void onResponse(Call<EdamamRecipeSearchResponse> call, Response<EdamamRecipeSearchResponse> response) {



                hideProgressbar();
                if(response.isSuccessful()) {

                recipes = response.body().getHits();
                mAdapter = new RecipeListAdapter(RecipesActivity.this, recipes);
                mRecyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecipesActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setHasFixedSize(true);


                    Log.e(TAG,String.valueOf(recipes));

                //   ArrayAdapter adapter = new MyRecipesAdapter(RecipesActivity.this, android.R.layout.simple_list_item_1, allRecipes, sources, urls, images);
                    //mListViewRecipes.setAdapter(adapter);
                    showRecipes();
                } else {
                    showUnsuccessfulMessage();
                }


            }

            @Override
            public void onFailure(Call<EdamamRecipeSearchResponse> call, Throwable t) {
                Log.e("Error Message", "onFailure: ",t );
                hideProgressbar();
                showFailureMessage();
            }
        });






    }
}