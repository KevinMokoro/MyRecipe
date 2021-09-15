package com.moringaschool.myrecipe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EdamamApi {
    @GET("api/recipes")
    Call<EdamamRecipeSearchResponse> getRecipes (
            @Query("q") String q,
            @Query("type") String type
    );

}
