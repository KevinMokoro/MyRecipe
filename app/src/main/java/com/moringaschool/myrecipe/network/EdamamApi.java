package com.moringaschool.myrecipe.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EdamamApi {
    @GET("recipes/findByIngredients")
    Call<SpoonacularRecipeSearchResponse> getRecipes(
            @Query("ingredient") String ingredient
    );
}
