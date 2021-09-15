package com.moringaschool.myrecipe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpoonacularApi {
    @GET("recipes/findByIngredients")
    Call<SpoonacularRecipeSearchResponse> getRecipes(
            @Query("ingredient") String ingredient
    );
}
