package com.example.caffeine.screens.customCoffee.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.extensions.dropShadow
import com.example.caffeine.ui.theme.AppTypography

@Composable
fun CoffeeSelector(
    allLevels: List<String> = listOf("Low", "Medium", "High"),
    selectedLevel: String,
    onClick: (String) -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .background(Color(0xffF5F5F5))
                .padding(horizontal = 4.dp, vertical = 8.dp)
        ) {
            allLevels.forEach { level ->
                val isSelected = level == selectedLevel

                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .then(
                            if (isSelected) {
                                Modifier.Companion.dropShadow(
                                    shape = CircleShape,
                                    color = Color(0x80B94B23),
                                    blur = 16.dp,
                                    offsetY = 6.dp,
                                )
                            } else Modifier
                        )
                ) {
                    AnimatedContent(
                        targetState = isSelected,
                        transitionSpec = {
                            fadeIn(animationSpec = tween(durationMillis = 500)) togetherWith
                                    fadeOut(animationSpec = tween(durationMillis = 500))
                        },
                        label = "coffee_selector_button_animation"
                    ) { targetIsSelected ->
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .clickable { onClick(level) }
                                .background(
                                    if (targetIsSelected) Color(0xFF7C351B)
                                    else Color.Transparent
                                )
                                .padding(horizontal = 10.dp, vertical = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.coffee_beans),
                                contentDescription = "Product Image",
                                tint = if (targetIsSelected) Color(0xDEFFFFFF) else Color.Transparent,
                            )
                        }
                    }
                }
            }
        }

        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(horizontal = 4.dp)
        ) {
            allLevels.forEach { level ->
                Text(
                    text = level,
                    style = AppTypography.labelSmall,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                )
            }
        }
    }
}