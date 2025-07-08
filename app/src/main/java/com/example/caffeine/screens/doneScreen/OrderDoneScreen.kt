package com.example.caffeine.screens.doneScreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.caffeine.Navigation.AppDestination
import com.example.caffeine.R
import com.example.caffeine.screens.doneScreen.components.CoffeeSwitchButton
import com.example.caffeine.screens.shared.CancelButton
import com.example.caffeine.screens.doneScreen.components.DoneMessage
import com.example.caffeine.screens.doneScreen.components.AnimatedCoffeeCup
import com.example.caffeine.screens.shared.BaseButton
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun OrderDoneScreen(
    navController: NavController
) {
    val headerOffsetY = remember { Animatable(-300f) }
    val cupCoverOffsetY = remember { Animatable(-300f) }
    val buttonOffsetY = remember { Animatable(300f) }

    LaunchedEffect(Unit) {
        coroutineScope {
            launch {
                headerOffsetY.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 800)
                )
            }

            launch {
                cupCoverOffsetY.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 800)
                )
            }

            launch {
                buttonOffsetY.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 800)
                )
            }
        }
    }
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
            Column(
                modifier = Modifier.offset(y = headerOffsetY.value.dp),
                horizontalAlignment = CenterHorizontally
            ) {
                CancelButton(
                    bottomSpace = 16.dp,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    onClick = {
                        navController.popBackStack(
                            route = AppDestination.GhostScreen.route,
                            inclusive = false
                        )
                    }
                )
                DoneMessage()
            }

            AnimatedCoffeeCup(coverOffsetY = cupCoverOffsetY.value)
            Spacer(modifier = Modifier.weight(1f))
            CoffeeSwitchButton()
            Spacer(modifier = Modifier.height(16.dp))
            BaseButton(
                onClick = { navController.navigate(AppDestination.SnackSelectionScreen.route)},
                text = "Take snack",
                icon = painterResource(R.drawable.arrow),
                modifier = Modifier.offset(y = buttonOffsetY.value.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}

