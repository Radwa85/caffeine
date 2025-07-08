package com.example.caffeine.screens.doneScreen.components

import androidx.compose.animation.core.tween
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.RedBrown
import com.example.caffeine.ui.theme.UrbanistFontFamily
import com.example.caffeine.ui.theme.WhiteAlpha87

@Composable
fun CoffeeSwitchButton() {
    var isChecked by remember { mutableStateOf(false) }

    val iconOffset by animateDpAsState(
        targetValue = if (isChecked) 40.dp else 0.dp,
        animationSpec = tween(durationMillis = 800),
        label = "Coffee Switch Animation"
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(width = 78.dp, height = 40.dp)
                .clip(RoundedCornerShape(100.dp))
                .clickable { isChecked = !isChecked }
                .background(if (isChecked) Color(0xFFFFEEE7) else RedBrown),
        ) {

            Text(
                text = if (isChecked) "OFF" else "ON",
                color = if (isChecked) Color(0x991F1F1F)  else WhiteAlpha87 ,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                modifier = if (isChecked)
                    Modifier.align(Alignment.CenterStart).padding(start = 12.dp)
                else
                    Modifier.align(Alignment.CenterEnd).padding(end = 12.dp)
            )

            Image(
                painter = painterResource(R.drawable.coffee_switcher),
                contentDescription = "coffee switch",
                modifier = Modifier.offset(x = iconOffset)
            )
        }

        Text(
            text = "Take Away",
            color = Color(0xB21F1F1F),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            fontFamily = UrbanistFontFamily,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
