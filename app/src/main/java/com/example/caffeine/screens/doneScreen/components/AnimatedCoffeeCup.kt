package com.example.caffeine.screens.doneScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R

@Composable
fun AnimatedCoffeeCup(coverOffsetY: Float) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = TopCenter
    ) {
        Image(
            painter = painterResource(R.drawable.big_cup),
            contentDescription = "Product Image",
            modifier = Modifier.padding(top = 16.dp).size(width = 245.dp, height = 300.dp),
        )
        Image(
            painter = painterResource(R.drawable.cup_cover),
            contentDescription = "Product Image",
            modifier = Modifier
                .padding(top = 4.dp)
                .offset(y = coverOffsetY.dp)
                .size(width = 260.dp, height = 69.dp)
        )
    }
}