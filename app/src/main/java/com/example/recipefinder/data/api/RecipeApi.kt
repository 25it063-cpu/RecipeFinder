package com.example.recipefinder.data.api

import com.example.recipefinder.data.model.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    @GET("search.php")
    suspend fun searchRecipes(
        @Query("s") query: String
    ): RecipeResponse
}