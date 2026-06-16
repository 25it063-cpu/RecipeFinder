package com.example.recipefinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recipefinder.ui.screens.HomeScreen
import com.example.recipefinder.viewmodel.RecipeViewModel
import com.example.recipefinder.ui.navigation.NavGraph
import com.example.recipefinder.viewmodel.SharedRecipeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val sharedVM: SharedRecipeViewModel = viewModel()

            NavGraph(sharedVM = sharedVM)
        }
    }
}