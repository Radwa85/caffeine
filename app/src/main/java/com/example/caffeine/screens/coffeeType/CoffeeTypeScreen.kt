package com.example.caffeine.screens.coffeeType

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.screens.shared.BaseButton
import com.example.caffeine.screens.coffeeType.components.CoffeePager
import com.example.caffeine.screens.coffeeType.components.WelcomeMessage
import com.example.caffeine.screens.shared.ProfileHeader

data class Coffee(
    val title: String,
    val image: Int,
)

val coffeeList = listOf(
    Coffee("Espresso", R.drawable.espresso),
    Coffee("Macchiato", R.drawable.macchiato),
    Coffee("Latte", R.drawable.latte),
    Coffee("Black", R.drawable.black),
)

@Composable
fun CoffeeTypeScreen(
    navController: NavController
) {
    val currentCoffeeTitle = remember { mutableStateOf(coffeeList.first().title) }

    CoffeeTypeContent(
        onAddClick = {},
        onSelectionChanged = {
            currentCoffeeTitle.value = it
        },
        onButtonClick = { navController.navigate("ProductScreen?title=${currentCoffeeTitle.value}") }, // Pass title as argument
    )
}

@Composable
fun CoffeeTypeContent(
    onButtonClick: () -> Unit,
    onAddClick: () -> Unit,
    onSelectionChanged: (String) -> Unit,
) {
    Scaffold(
        containerColor = Color.White
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .padding(vertical = 16.dp),
            horizontalAlignment = CenterHorizontally,
        ) {
            ProfileHeader(onAddClick = onAddClick)
            Spacer(modifier = Modifier.height(16.dp))
            WelcomeMessage()
            Spacer(modifier = Modifier.height(32.dp))
            CoffeePager(onSelectionChanged = onSelectionChanged)
            Spacer(modifier = Modifier.weight(1f))
            BaseButton(
                text = "Continue",
                icon = painterResource(R.drawable.arrow),
                onClick = onButtonClick
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}