package com.example.recipefinder.data.repository

import com.example.recipefinder.data.api.ApiClient
import com.example.recipefinder.data.model.Recipe

class RecipeRepository {

    private val api = ApiClient.api

    suspend fun getRecipes(query: String): List<Recipe> {
        return try {
            val response = api.searchRecipes(query)
            response.meals ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }
}