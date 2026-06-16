package com.example.recipefinder.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipefinder.viewmodel.SharedRecipeViewModel
import com.example.recipefinder.ui.components.RecipeCard

@Composable
fun FavoritesScreen(
    navController: NavController,
    sharedVM: SharedRecipeViewModel
) {

    val favorites = sharedVM.favorites

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Favorites ❤️",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        if (favorites.isEmpty()) {
            Text("No favorite recipes yet 😢")
            return
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(favorites) { recipe ->

                RecipeCard(
                    title = recipe.strMeal,
                    image = recipe.strMealThumb,
                    onClick = {
                        sharedVM.selectRecipe(recipe)
                        navController.navigate("detail")
                    }
                )
            }
        }
    }
}