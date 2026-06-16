package com.example.recipefinder.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.recipefinder.viewmodel.SharedRecipeViewModel
import com.example.recipefinder.data.model.Recipe
import com.example.recipefinder.utils.getIngredients

@Composable
fun RecipeDetailScreen(
    navController: NavController,
    sharedVM: SharedRecipeViewModel
) {

    val recipe by sharedVM.selectedRecipe.collectAsState()

    if (recipe == null) {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("No recipe selected")
        }
        return
    }

    val r = recipe!!

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFECE9E6))
    ) {

        // IMAGE
        AsyncImage(
            model = r.strMealThumb,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Spacer(Modifier.height(16.dp))

        // TITLE
        Text(
            text = r.strMeal,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(Modifier.height(12.dp))

        // ADD TO FAVORITES BUTTON
        val isFav = sharedVM.isFavorite(r)

        Button(
            onClick = {
                sharedVM.toggleFavorite(r)
            }
        ) {
            Text(
                if (isFav) "Remove from Favorites ❤️"
                else "Add to Favorites 🤍"
            )
        }

        Spacer(Modifier.height(16.dp))

        // INGREDIENT TITLE
        Text(
            text = "Ingredients",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(Modifier.height(8.dp))

        // INGREDIENT LIST
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(r.getIngredients()) { item ->
                Text("• $item")
            }
        }
    }
}