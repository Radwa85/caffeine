package com.example.caffeine.screens.doneScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.extensions.dropShadow
import com.example.caffeine.ui.theme.PrimaryBlack
import com.example.caffeine.ui.theme.RedBrown
import com.example.caffeine.ui.theme.UrbanistFontFamily
import com.example.caffeine.ui.theme.WhiteAlpha87


@Composable
fun DoneMessage() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,

    ) {

        Box(
            Modifier
                .padding(bottom = 24.dp)
                .dropShadow(
                    shape = CircleShape,
                    color = Color(0x80B94B23),
                    blur = 16.dp,
                    offsetY = 6.dp,
                )
                .size(56.dp)
                .clip(CircleShape)
                .background(RedBrown)
                .padding(horizontal = 10.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.tick_02),
                contentDescription = "Product Image",
                tint = WhiteAlpha87,
            )
        }
        Text(
            text = "Your coffee is ready,\nEnjoy",
            color = PrimaryBlack,
            fontSize = 22.sp,
            fontFamily = UrbanistFontFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            letterSpacing = 0.25.sp,
        )
    }
}