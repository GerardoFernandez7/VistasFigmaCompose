package com.joseruiz.project_recipes.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.joseruiz.project_recipes.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


// Función para el encabezado de la vista
@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu",
            tint = Color.Red
        )
        Text(
            text = "POPULAR RECIPES",
            style = MaterialTheme.typography.headlineSmall.copy(color = Color.Red)
        )
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            tint = Color.Red
        )
    }
}

@Composable
fun CategoryTabs() {
    val selectedIndex = remember { mutableStateOf(1) } // Empieza con "Entrees"
    val categories = listOf("APPETIZERS", "ENTREES", "DESSERT")

    // Sirve para crear el menú de navegación
    TabRow(
        selectedTabIndex = selectedIndex.value,
        containerColor = Color.Transparent,
        contentColor = Color.Black,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier
                    .tabIndicatorOffset(tabPositions[selectedIndex.value])
                    .height(2.dp)
                    .background(Color.Black)
            )
        }
    ) {
        categories.forEachIndexed { index, title ->
            Tab(
                text = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyLarge, // Usando bodyLarge en lugar de body1
                        color = if (selectedIndex.value == index) Color.Black else Color.Gray
                    )
                },
                selected = selectedIndex.value == index,
                onClick = { selectedIndex.value = index }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun RecipeCarousel(navController: NavController) {
    // Imágenes de las recetas
    val images = listOf(
        R.drawable.hamburguesa,
        R.drawable.pizza,
        R.drawable.asado,
        R.drawable.lasagna,
        R.drawable.tacos,
        R.drawable.langosta
    )

    val recipeTitles = listOf(
        "Perfect Burger", "Fantastic Pizza", "Prime Rib Roast",
        "Classic Lasagna", "Delicious Tacos", "Exquisite Lobster"
    )

    val contentRecipes = listOf(
        "The burger is a classic of fast food, known for its juicy flavor and versatility. Learn how to make the perfect burger to delight your family and friends. Check out the award-winning recipe and step-by-step tutorial from \"What's Cooking in America\" to help you make the perfect burger.",
        "Pizza is an iconic dish that combines a crispy crust with an endless variety of fresh ingredients. Discover how to make the perfect pizza to share with your loved ones. Check out the award-winning recipe and photo tutorial from \"What's Cooking in America\" to make the perfect pizza at home.",
        "The Prime Rib Roast is a classic and tender cut of beef taken from the rib primal cut. Learn how to make the perfect prime rib roast to serve your family and friends. Check out What's Cooking America's award-winning Classic Prime Rib Roast recipe and photo tutorial to help you make the Perfect Prime Rib Roast.",
        "Lasagna is a comforting dish that combines layers of pasta, meat, and cheese in a delicious harmony of flavors. Learn how to make the perfect lasagna to enjoy with your family. Check out the award-winning recipe and detailed tutorial from \"What's Cooking in America\" to make a lasagna that everyone will love.",
        "Tacos are a dish full of flavor and tradition that offers a wide variety of combinations. Discover how to make delicious tacos that your guests will love. Check out the award-winning recipe and tutorial from \"What's Cooking in America\" to make perfect tacos at home.",
        "Lobster is an exquisite delicacy that offers a luxurious culinary experience. Learn how to cook perfect lobster to impress on any special occasion. Check out the award-winning recipe and photo tutorial from \"What's Cooking in America\" to prepare lobster like a professional chef.",
    )

    val cookingTimes = listOf("5HR", "2HR", "30MIN", "1HR", "45MIN", "1.5HR")
    val likes = listOf("685", "432", "298", "876", "765", "342")
    val comments = listOf("107", "55", "34", "120", "89", "42")

    val pagerState = rememberPagerState()

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            count = images.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
        ) { page ->
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(Color.White)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                // Imagen
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = recipeTitles[page],
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            // Navegar a otra vista pasando el nombre de la receta
                            navController.navigate("recipe_detail/${recipeTitles[page]}")
                        }
                )

                // Título de la receta
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = recipeTitles[page], style = MaterialTheme.typography.headlineSmall)
                }

                // Información debajo de la imagen
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.DateRange, contentDescription = "Time", tint = Color.Red)
                        Text(text = cookingTimes[page], style = MaterialTheme.typography.bodyMedium)
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = "Likes", tint = Color.Red)
                        Text(text = likes[page], style = MaterialTheme.typography.bodyMedium)
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.MailOutline, contentDescription = "Comments", tint = Color.Red)
                        Text(text = comments[page], style = MaterialTheme.typography.bodyMedium)
                    }
                }

                // Descripción
                Text(
                    text = contentRecipes[page],
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
fun RecipeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Header()
        CategoryTabs()
        RecipeCarousel(navController)
    }
}