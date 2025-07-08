package com.example.caffeine.screens.loading

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.Navigation.AppDestination

import com.example.caffeine.screens.shared.CupSize
import com.example.caffeine.screens.loading.components.TimerText
import com.example.caffeine.screens.loading.components.LoadingLineAnimation

import com.example.caffeine.ui.theme.UrbanistFontFamily
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Composable
fun LoadingScreen(
    navController: NavController,
    selectedSize: String
) {
    LaunchedEffect(Unit) {
        delay(3500)
        withContext(Dispatchers.Main) {
            navController.navigate(AppDestination.DoneScreen.route)
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
            Spacer(modifier = Modifier.height(88.dp))
            CupSize(
                selectedSize = selectedSize
            )
            Spacer(modifier = Modifier.weight(1f))

            LoadingLineAnimation()

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Almost Done",
                fontFamily = UrbanistFontFamily,
                color = Color(0xDE1F1F1F),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Text(
                text = "Your coffee will be finish in",
                fontFamily = UrbanistFontFamily,
                color = Color(0x991F1F1F),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            TimerText()
        }
    }
}

