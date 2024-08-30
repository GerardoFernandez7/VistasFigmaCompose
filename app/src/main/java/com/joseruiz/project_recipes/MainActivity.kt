package com.joseruiz.project_recipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joseruiz.project_recipes.screens.MenuScreen
import com.joseruiz.project_recipes.screens.RecipeScreen
import com.joseruiz.project_recipes.ui.theme.ProjectRecipesTheme
import com.joseruiz.project_recipes.screens.RecipeDetailScreen
import com.joseruiz.project_recipes.screens.SuccessDialog

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectRecipesTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "menu") {
                    composable(route = "menu"){
                        MenuScreen(navController = navController)
                    }
                    composable(route = "home"){
                        RecipeScreen(navController = navController)
                    }
                    composable("recipe_detail/{recipeName}") { backStackEntry ->
                        val recipeName = backStackEntry.arguments?.getString("recipeName") ?: ""
                        RecipeDetailScreen(recipeName)
                    }
                }
            }
        }
    }
}

