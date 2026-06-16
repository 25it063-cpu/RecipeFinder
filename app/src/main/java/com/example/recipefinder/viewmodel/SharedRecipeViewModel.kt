package com.example.recipefinder.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.recipefinder.data.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SharedRecipeViewModel : ViewModel() {

    // selected recipe for detail screen
    private val _selectedRecipe = MutableStateFlow<Recipe?>(null)
    val selectedRecipe: StateFlow<Recipe?> = _selectedRecipe

    fun selectRecipe(recipe: Recipe) {
        _selectedRecipe.value = recipe
    }

    // ⭐ FAVORITES LIST
    val favorites = mutableStateListOf<Recipe>()

    fun isFavorite(recipe: Recipe): Boolean {
        return favorites.contains(recipe)
    }

    fun toggleFavorite(recipe: Recipe) {
        if (favorites.contains(recipe)) {
            favorites.remove(recipe)
        } else {
            favorites.add(recipe)
        }
    }
    fun addFavorite(recipe: Recipe) {
        if (!favorites.contains(recipe)) {
            favorites.add(recipe)
        }
    }

    fun removeFavorite(recipe: Recipe) {
        favorites.remove(recipe)
    }
}