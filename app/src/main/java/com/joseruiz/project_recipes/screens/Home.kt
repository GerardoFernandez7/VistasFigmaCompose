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
        "Perfect Burger", "Pizza", "Prime Rib Roast",
        "Lasaña", "Tacos", "Langosta"
    )

    val contentRecipes = listOf(
        "La hamburguesa es un clásico de la cocina rápida, conocida por su sabor jugoso y su versatilidad. Aprende a preparar la hamburguesa perfecta para deleitar a tu familia y amigos. Consulta la receta galardonada y el tutorial paso a paso de \"Lo que se Cocina en América\" para ayudarte a hacer la hamburguesa ideal.",
        "La pizza es un plato emblemático que combina una base crujiente con una variedad infinita de ingredientes frescos. Descubre cómo preparar la pizza perfecta para compartir con tus seres queridos. Revisa la receta premiada y el tutorial fotográfico de \"Lo que se Cocina en América\" para hacer la pizza ideal en tu hogar.",
        "El asado es una tradición culinaria rica y sabrosa, ideal para reuniones familiares y celebraciones. Aprende a hacer un asado perfecto que cautivará a todos en tu mesa. Consulta la receta galardonada y el tutorial de \"Lo que se Cocina en América\" para lograr el asado perfecto.",
        "La lasaña es un plato reconfortante que combina capas de pasta, carne y queso en una deliciosa armonía de sabores. Aprende a preparar la lasaña perfecta para disfrutar en familia. Revisa la receta premiada y el tutorial detallado de \"Lo que se Cocina en América\" para hacer una lasaña que todos adorarán.",
        "Los tacos son un plato lleno de sabor y tradición que ofrece una gran variedad de combinaciones. Descubre cómo preparar tacos deliciosos que encantarán a tus invitados. Consulta la receta galardonada y el tutorial de \"Lo que se Cocina en América\" para hacer tacos perfectos en casa.",
        "La langosta es un manjar exquisito que ofrece una experiencia culinaria de lujo. Aprende a cocinar langosta perfecta para impresionar en cualquier ocasión especial. Consulta la receta premiada y el tutorial fotográfico de \"Lo que se Cocina en América\" para preparar langosta como un chef profesional."
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
                    modifier = Modifier.padding(8.dp)
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