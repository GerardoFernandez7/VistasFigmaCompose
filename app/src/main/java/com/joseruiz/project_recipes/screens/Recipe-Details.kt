package com.joseruiz.project_recipes.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Recipe(
    val title: String,
    val description: String,
    val imageResourceId: Int,
    val ingredients: List<String>,
    val preparationSteps: List<String>,
    val comments: List<Comment>
)

data class Comment(
    val userName: String,
    val date: String,
    val commentText: String
)

val recipes = listOf(
    Recipe(
        "Prime Rib Roast",
        "The Prime Rib Roast is a classic and tender cut of beef taken from the rib primal cut. Learn how to make the perfect prime rib roast to serve your family and friends. Check out What's Cooking America's award-winning Classic Prime Rib Roast recipe and photo tutorial to help you make the Perfect Prime Rib Roast.",
        com.joseruiz.project_recipes.R.drawable.prime_roast,
        listOf(
            "1 Prime Rib Roast (standing rib)",
            "1/2 cup good-quality balsamic vinegar",
            "1 cup (packed) Italian parsley leaves",
            "8 cloves garlic, minced",
            "1/4 teaspoon salt",
            "Freshly ground pepper to taste",
            "1 cup water",
            "3 drops Worcestershire sauce"
        ),
        listOf(
            "Preheat oven to 350 degrees F.",
            "With medium-high heat, boil...",
            "Finely mince the parsley...",
            "Add any accumulated meat juices.."
        ),
        listOf(
            Comment("TOM KLEIN", "7.01.2017", "The prime rib roast was amazing!!!"),
            Comment("SALLY PARKER", "7.01.2017", "I was amazed at how little preparation this took. Just rub on the herbs and butter, let it sit for a few hours and you have an amazing piece of meat!")
        )
    ),
    Recipe(
        "Perfect Burger",
        "The burger is a classic of fast food, known for its juicy flavor and versatility. Learn how to make the perfect burger to delight your family and friends. Check out the award-winning recipe and step-by-step tutorial from \"What's Cooking in America\" to help you make the perfect burger.",
        com.joseruiz.project_recipes.R.drawable.burger,
        listOf(
            "1 pound ground beef (80% lean)",
            "1 teaspoon salt",
            "1/2 teaspoon black pepper",
            "4 hamburger buns",
            "4 slices cheese (optional)",
            "Lettuce, tomato, onion for toppings"
        ),
        listOf(
            "Mix ground beef with salt and pepper.",
            "Form into 4 patties, about 3/4 inch thick.",
            "Grill or pan-fry for 3-4 minutes each side.",
            "Add cheese if desired, and serve on buns with toppings."
        ),
        listOf(
            Comment("BURGER LOVER", "5.15.2023", "Best homemade burgers ever!"),
            Comment("GRILLMASTER", "6.20.2023", "The tips for forming the patties were spot on. Juicy results!")
        )
    ),
)

@Composable
fun RecipeDetailScreen(recipeName: String) {
    val scrollState = rememberScrollState()
    val recipe = recipes.find { it.title == recipeName } ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        RecipeImageSection(recipe.imageResourceId)
        RecipeTitleSection(recipe.title, recipe.description)
        Spacer(modifier = Modifier.height(16.dp))
        ShoppingListSection(recipe.ingredients)
        Spacer(modifier = Modifier.height(16.dp))
        PreparationSection(recipe.preparationSteps)
        Spacer(modifier = Modifier.height(16.dp))
        CommentsSection(recipe.comments)
        Spacer(modifier = Modifier.height(16.dp))
        CommentInputSection()
    }
}

@Composable
fun RecipeImageSection(imageResourceId: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = imageResourceId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        )
        IconButton(
            onClick = { /* Logica de boton fav */ },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(1.dp)
        ) {
            Icon(
                painter = painterResource(id = com.joseruiz.project_recipes.R.drawable.ic_favorite_border),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.padding(top = 3.dp)
                    .size(24.dp)
            )
        }
    }
}

@Composable
fun RecipeTitleSection(title: String, description: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Centrar el contenido del Column
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(5) {
                Icon(
                    painter = painterResource(id = com.joseruiz.project_recipes.R.drawable.ic_star),
                    contentDescription = null,
                    tint = Color(0xFFF2C94C),  // Color dorado para la estrella
                    modifier = Modifier.size(24.dp),
                )
                if (it < 4) { // Añade un Spacer entre las estrellas, excepto después de la última
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))  // Espacio entre las estrellas y el título
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color(0xFF19597D)
        )
        Spacer(modifier = Modifier.height(8.dp))  // Espacio entre el título y la descripción
        Text(
            text = description,
            fontSize = 16.sp,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center // Alinear el texto al centro
        )
    }
}

@Composable
fun ShoppingListSection(ingredients: List<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = com.joseruiz.project_recipes.R.drawable.ic_shopping_cart),
            contentDescription = null,
            tint = Color(0xFFEB5757),
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = "SHOPPING LIST",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFF19597D),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        ingredients.forEach { ingredient ->
            Text(text = ingredient)
        }
    }
}

@Composable
fun PreparationSection(steps: List<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = com.joseruiz.project_recipes.R.drawable.ic_preparation),
            contentDescription = null,
            tint = Color(0xFFEB5757),
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = "PREPARATION",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFF19597D),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        steps.forEachIndexed { index, step ->
            Text(text = "${index + 1}. $step")
        }
    }
}

@Composable
fun CommentsSection(comments: List<Comment>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Icon(
            painter = painterResource(id = com.joseruiz.project_recipes.R.drawable.ic_comment),
            contentDescription = null,
            tint = Color(0xFFEB5757),
            modifier = Modifier.size(30.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp)
        )
        Text(
            text = "COMMENTS",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp),
            color = Color(0xFF19597D)
        )

        comments.forEach { comment ->
            CommentItem(comment)
        }
    }
}

@Composable
fun CommentItem(comment: Comment) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = com.joseruiz.project_recipes.R.drawable.profile_placeholder),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = comment.userName, fontWeight = FontWeight.Bold)
            Text(text = comment.date, fontSize = 12.sp, color = Color.Gray)
            Text(text = comment.commentText)
        }
    }
}

// CommentInputSection remains the same...

@Composable
fun CommentInputSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        TextField(
            value = "",
            onValueChange = { /* Handle text change */ },
            placeholder = { Text(text = "Type your comment here...") },
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),


            )
        IconButton(
            onClick = { /* Handle send comment */ },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                painter = painterResource(id = com.joseruiz.project_recipes.R.drawable.ic_send),
                contentDescription = null
            )
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun RecipeDetailScreenPreview() {
    RecipeDetailScreen()
}
 */

@Preview(showBackground = true)
@Composable
fun RecipeDetailScreenPreview() {
    RecipeDetailScreen(recipeName = "Perfect Burger")
}