package com.moringaschool.myrecipe.network;

import com.moringaschool.myrecipe.models.EdamamRecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EdamamApi {
    @GET("api/recipes/v2")
    Call<EdamamRecipeSearchResponse>getRecipes (
            @Query("type") String type,
            @Query("q") String ingredient,
            @Query("app_id") String api_id,
            @Query("app_key") String api_key
    );

}
