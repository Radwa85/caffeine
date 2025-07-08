package com.example.caffeine.screens.customCoffee

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.caffeine.Navigation.AppDestination
import com.example.caffeine.R
import com.example.caffeine.screens.customCoffee.components.BackButtonHeader
import com.example.caffeine.screens.customCoffee.components.BeanAnimationDirection
import com.example.caffeine.screens.customCoffee.components.CoffeeSelector
import com.example.caffeine.screens.shared.CupSize
import com.example.caffeine.screens.customCoffee.components.FallingBeans
import com.example.caffeine.screens.customCoffee.components.SizeSelector
import com.example.caffeine.screens.shared.BaseButton

@Composable
fun CustomCoffeeScreen(
    navController: NavController,
    title: String?
) {
    var selectedCupSize by rememberSaveable { mutableStateOf("M") }
    var selectedCoffeeLevel by rememberSaveable { mutableStateOf("Medium") }
    var triggerBeanDrop by rememberSaveable { mutableStateOf(0) }
    var beanDirection by rememberSaveable { mutableStateOf(BeanAnimationDirection.DOWN) }
    val selectedLevelsHistory = rememberSaveable { mutableSetOf("Medium") }
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
            BackButtonHeader(
                bottomSpace = 16.dp,
                modifier = Modifier.padding(horizontal = 16.dp),
                title = title ?: "Unknown",
            ) {
                navController.popBackStack()
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(310.dp + 48.dp + 16.dp),
                contentAlignment = Alignment.Center
            ) {
                CupSize(selectedSize = selectedCupSize)

                FallingBeans(
                    triggerDrop = triggerBeanDrop,
                    onAnimationComplete = {
                    },
                    cupSize = selectedCupSize,
                    direction = beanDirection,
                    modifier = Modifier.align(Alignment.Center)
                )
            }


            SizeSelector(
                allSizes = listOf("S", "M", "L"),
                selectedSize = selectedCupSize,
                onClick = { newSize ->
                    selectedCupSize = newSize
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            CoffeeSelector(
                allLevels = listOf("Low", "Medium", "High"),
                selectedLevel = selectedCoffeeLevel,
                onClick = { newLevel ->
                    selectedCoffeeLevel = newLevel

                    beanDirection = if (selectedLevelsHistory.contains(newLevel)) {
                        BeanAnimationDirection.UP
                    } else {
                        BeanAnimationDirection.DOWN
                    }
                    selectedLevelsHistory.add(newLevel)
                    triggerBeanDrop++
                }

            )

            Spacer(modifier = Modifier.weight(1f))

            BaseButton(
                text = "Continue",
                icon = painterResource(R.drawable.arrow),
                onClick = {
                    navController.navigate(AppDestination.LoadingScreen.createRoute(selectedCupSize))
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}