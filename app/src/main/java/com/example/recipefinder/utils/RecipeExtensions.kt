package com.example.recipefinder.utils

import com.example.recipefinder.data.model.Recipe

fun Recipe.getIngredients(): List<String> {
    return listOfNotNull(
        strIngredient1?.takeIf { it.isNotBlank() },
        strIngredient2?.takeIf { it.isNotBlank() },
        strIngredient3?.takeIf { it.isNotBlank() },
        strIngredient4?.takeIf { it.isNotBlank() },
        strIngredient5?.takeIf { it.isNotBlank() }
    )
}