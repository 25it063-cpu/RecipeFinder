package com.example.recipefinder.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.recipefinder.ui.components.RecipeCard
import com.example.recipefinder.viewmodel.RecipeViewModel
import com.example.recipefinder.viewmodel.SharedRecipeViewModel
import com.example.recipefinder.ui.theme.AppColors
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

@Composable
fun HomeScreen(
    vm: RecipeViewModel = viewModel(),
    navController: NavController,
    sharedVM: SharedRecipeViewModel
) {

    val recipes by vm.recipes.collectAsState()
    val loading by vm.loading.collectAsState()

    var query by remember { mutableStateOf("chicken") }
    var selectedCategory by remember { mutableStateOf("Breakfast") }

    LaunchedEffect(Unit) {
        vm.searchRecipes(query)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.Background)
            .padding(20.dp)
    ) {

        /*Text(
            text = "All recipes",
            style = MaterialTheme.typography.headlineLarge
        )*/

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "All recipes",
                style = MaterialTheme.typography.headlineLarge,
                color = AppColors.PrimaryText
            )

            IconButton(
                onClick = {
                    navController.navigate("favorites")
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorites",
                    tint = Color.Red
                )
            }
        }

        //now Spacer(Modifier.height(16.dp))

        /*Button(
            onClick = {
                navController.navigate("favorites")
            }
        ) {
            Text("Go to Favorites ❤️")
        }*/

        Spacer(Modifier.height(16.dp))

        // SEARCH
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(50))
                .background(Color.White)
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(Icons.Default.Search, contentDescription = null)

            Spacer(Modifier.width(8.dp))

            TextField(
                value = query,
                onValueChange = {
                    query = it
                    vm.searchRecipes(it)
                },
                placeholder = { Text("Search here") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

        Spacer(Modifier.height(16.dp))



        // CATEGORY
        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {

            val categories = listOf("Breakfast", "Lunch", "Dinner", "Snack")

            items(categories) { item ->

                val isSelected = item == selectedCategory

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(if (isSelected) AppColors.ChipActive else Color.White)
                        .clickable {
                            selectedCategory = item
                            vm.searchRecipes(item)
                        }
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = item,
                        color = if (isSelected) Color.White else AppColors.PrimaryText
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        if (loading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {

                items(recipes) { recipe ->

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
}