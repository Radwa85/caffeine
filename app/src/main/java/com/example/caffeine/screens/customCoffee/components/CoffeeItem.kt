package com.example.caffeine.screens.customCoffee.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.screens.coffeeType.Coffee
import com.example.caffeine.R

@Composable
fun CoffeeItem(coffee: Coffee) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(coffee.image),
                contentDescription = coffee.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .height(258.dp)
            )
            Image(
                painter = painterResource(R.drawable.tc_logo),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(66.dp)
                    .align(Alignment.Center)
                    .offset(y = 20.dp)
            )
        }

        Text(
            text = coffee.title,
            color = Color(0xFF1f1f1f),
            fontSize = 32.sp,
            fontWeight = FontWeight.W700,
        )
    }
}