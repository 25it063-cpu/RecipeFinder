package com.example.recipefinder.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.recipefinder.ui.screens.*
import com.example.recipefinder.viewmodel.SharedRecipeViewModel

@Composable
fun NavGraph(sharedVM: SharedRecipeViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController = navController, sharedVM = sharedVM)
        }

        composable("detail") {
            RecipeDetailScreen(navController = navController, sharedVM = sharedVM)
        }

        // ⭐ NEW SCREEN
        composable("favorites") {
            FavoritesScreen(navController = navController, sharedVM = sharedVM)
        }
    }
}