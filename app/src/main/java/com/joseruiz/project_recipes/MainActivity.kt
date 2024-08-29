package com.joseruiz.project_recipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.joseruiz.project_recipes.screens.RecipeScreen
import com.joseruiz.project_recipes.ui.theme.ProjectRecipesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectRecipesTheme {
                RecipeScreen()
            }
        }
    }
}

