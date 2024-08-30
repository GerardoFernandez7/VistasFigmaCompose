package com.joseruiz.project_recipes.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.*

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
    Recipe(
        "Fantastic Pizza",
        "Pizza is an iconic dish that combines a crispy crust with an endless variety of fresh ingredients. Discover how to make the perfect pizza to share with your loved ones. Check out the award-winning recipe and photo tutorial from \"What's Cooking in America\" to make the perfect pizza at home.",
        com.joseruiz.project_recipes.R.drawable.pizza,
        listOf(
            "2 1/4 teaspoons active dry yeast",
            "1 1/2 cups warm water",
            "3 1/2 cups all-purpose flour",
            "1 tablespoon olive oil",
            "1 teaspoon salt",
            "1/2 cup pizza sauce",
            "1 1/2 cups shredded mozzarella cheese",
            "Your favorite toppings (pepperoni, vegetables, etc.)"
        ),
        listOf(
            "In a small bowl, dissolve yeast in warm water and let it sit for about 5 minutes.",
            "In a large bowl, combine flour and salt. Add the yeast mixture and olive oil, mixing until dough forms.",
            "Knead the dough on a floured surface until smooth. Let rise in a warm place for 1 hour.",
            "Preheat oven to 475°F (245°C). Roll out dough on a floured surface to desired thickness.",
            "Spread pizza sauce over the dough, add cheese and toppings. Bake for 12-15 minutes until crust is golden and cheese is bubbly."
        ),
        listOf(
            Comment("PIZZA FANATIC", "8.25.2023", "This pizza was a hit with my family! The crust was perfectly crispy."),
            Comment("CHEF JOHN", "8.26.2023", "Great recipe! The detailed steps helped me make the perfect pizza.")
        )
    ),
    Recipe(
        "Classic Lasagna",
        "Lasagna is a comforting dish that combines layers of pasta, meat, and cheese in a delicious harmony of flavors. Learn how to make the perfect lasagna to enjoy with your family. Check out the award-winning recipe and detailed tutorial from \"What's Cooking in America\" to make a lasagna that everyone will love.",
        com.joseruiz.project_recipes.R.drawable.lasagna,
        listOf(
            "1 pound ground beef",
            "1 onion, chopped",
            "2 cloves garlic, minced",
            "1 can (28 ounces) crushed tomatoes",
            "2 tablespoons tomato paste",
            "1 teaspoon dried basil",
            "1 teaspoon dried oregano",
            "12 lasagna noodles",
            "2 cups ricotta cheese",
            "2 cups shredded mozzarella cheese",
            "1/2 cup grated Parmesan cheese",
            "Salt and pepper to taste"
        ),
        listOf(
            "Preheat oven to 375°F (190°C).",
            "In a skillet, cook ground beef, onion, and garlic until beef is browned. Drain excess fat.",
            "Stir in crushed tomatoes, tomato paste, basil, and oregano. Simmer for 15 minutes. Season with salt and pepper.",
            "Cook lasagna noodles according to package instructions. Drain and set aside.",
            "In a baking dish, layer noodles, meat sauce, ricotta cheese, and mozzarella cheese. Repeat layers and top with Parmesan cheese.",
            "Bake for 45 minutes. Let cool for 10 minutes before serving."
        ),
        listOf(
            Comment("LASAGNA LOVER", "8.30.2023", "This lasagna was delicious and easy to make. Perfect for family dinners!"),
            Comment("COOKING ENTHUSIAST", "8.31.2023", "The layers came out perfect and the taste was just right. Highly recommend this recipe.")
        )
    ),
    Recipe(
        "Delicious Tacos",
        "Tacos are a dish full of flavor and tradition that offers a wide variety of combinations. Discover how to make delicious tacos that your guests will love. Check out the award-winning recipe and tutorial from \"What's Cooking in America\" to make perfect tacos at home.",
        com.joseruiz.project_recipes.R.drawable.tacos,
        listOf(
            "1 pound ground beef",
            "1 tablespoon taco seasoning",
            "8 taco shells",
            "1 cup shredded lettuce",
            "1 cup diced tomatoes",
            "1/2 cup chopped onions",
            "1/2 cup shredded cheddar cheese",
            "Sour cream and salsa for serving"
        ),
        listOf(
            "In a skillet, cook ground beef over medium heat until browned. Drain excess fat.",
            "Add taco seasoning to beef and mix well. Cook for another 5 minutes.",
            "Warm taco shells according to package instructions.",
            "Assemble tacos by adding seasoned beef to shells, then topping with lettuce, tomatoes, onions, and cheese.",
            "Serve with sour cream and salsa."
        ),
        listOf(
            Comment("TACO TUESDAY FAN", "9.01.2023", "These tacos were a hit at my party! Simple and tasty."),
            Comment("MEXICAN FOOD LOVER", "9.02.2023", "Great recipe! The seasoning was just perfect for the ground beef.")
        )
    ),
    Recipe(
        "Exquisite Lobster",
        "Lobster is an exquisite delicacy that offers a luxurious culinary experience. Learn how to cook perfect lobster to impress on any special occasion. Check out the award-winning recipe and photo tutorial from \"What's Cooking in America\" to prepare lobster like a professional chef.",
        com.joseruiz.project_recipes.R.drawable.langosta,
        listOf(
            "4 live lobsters",
            "4 quarts water",
            "1/4 cup salt",
            "1/4 cup unsalted butter, melted",
            "2 tablespoons lemon juice",
            "1 tablespoon chopped fresh parsley"
        ),
        listOf(
            "Bring a large pot of water to a boil. Add salt.",
            "Add lobsters to the boiling water and cook for 8-10 minutes until shells turn bright red.",
            "Remove lobsters and let cool slightly.",
            "In a small bowl, mix melted butter with lemon juice and parsley.",
            "Serve lobster with the butter mixture for dipping."
        ),
        listOf(
            Comment("LOBSTER LOVER", "9.05.2023", "The lobster turned out amazing! The butter dip was perfect."),
            Comment("SEAFOOD CHEF", "9.06.2023", "This recipe is fantastic for a special occasion. The lobster was cooked to perfection.")
        )
    )
)

@Composable
fun RecipeDetailScreen(recipeName: String) {
    val scrollState = rememberScrollState()
    val recipe = recipes.find { it.title == recipeName } ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
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
    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Image(
            painter = painterResource(id = imageResourceId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        )
        IconButton(
            onClick = { showDialog = true }, // Cambia el estado a true al hacer clic
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
        // Mostrar el diálogo si el estado showDialog es true
        if (showDialog) {
            SuccessDialog(onDismiss = {
                showDialog = false
            })
        }
    }
}

@Composable
fun RecipeTitleSection(title: String, description: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .padding(start = 16.dp)
            .padding(end = 16.dp),
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
            .padding(top = 16.dp)
            .padding(start = 16.dp)
            .padding(end = 16.dp),
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
            .padding(top = 16.dp)
            .padding(start = 16.dp)
            .padding(end = 16.dp),
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
            .padding(start = 16.dp)
            .padding(end = 16.dp)
    ) {
        Icon(
            painter = painterResource(id = com.joseruiz.project_recipes.R.drawable.ic_comment),
            contentDescription = null,
            tint = Color(0xFFEB5757),
            modifier = Modifier.size(35.dp)
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
            .padding(16.dp)
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
            onClick = { /* Logica de publicar comentario */ },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                painter = painterResource(id = com.joseruiz.project_recipes.R.drawable.ic_send),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeDetailScreenPreview() {
    RecipeDetailScreen(recipeName = "Exquisite Lobster")
}