package com.example.recipefinder.data.model

data class RecipeResponse(
    val meals: List<Recipe>?
)

data class Recipe(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,

    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,

    val strMeasure1: String?,
    val strMeasure2: String?,
    val strMeasure3: String?,
    val strMeasure4: String?,
    val strMeasure5: String?
)

