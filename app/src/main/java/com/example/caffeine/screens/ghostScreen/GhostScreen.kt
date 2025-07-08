package com.example.caffeine.screens.ghostScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.caffeine.Navigation.AppDestination
import com.example.caffeine.screens.ghostScreen.components.CoffeeContent
import com.example.caffeine.screens.shared.ProfileHeader
import com.example.caffeine.ui.theme.White
import com.example.caffeine.R
import com.example.caffeine.screens.shared.BaseButton

@Composable
fun GhostScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    onAddClick: () -> Unit = {},
) {

    Box(
        modifier = modifier
            .background(White)
            .systemBarsPadding(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            ProfileHeader(
                onAddClick = onAddClick
            )
            CoffeeContent(
                modifier = Modifier.weight(1f)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp),
                contentAlignment = Alignment.Center
            ) {
                BaseButton(
                    text = "Bring my coffee",
                    icon = painterResource(R.drawable.coffee_02),
                    onClick = { navController.navigate(AppDestination.CoffeeSelectionScreen.route) }
                )
            }
        }
    }
}
