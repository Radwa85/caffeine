package com.example.caffeine.screens.customCoffee.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.extensions.dropShadow
import com.example.caffeine.ui.theme.UrbanistFontFamily

@Composable
fun SizeSelector(
    allSizes: List<String> = listOf("S", "M", "L"),
    selectedSize: String,
    onClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .background(Color(0xffF5F5F5), RoundedCornerShape(100.dp))
            .padding(horizontal = 4.dp, vertical = 8.dp)
    ) {
        allSizes.forEach { size ->
            val isSelected = size == selectedSize

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
                        fadeIn(animationSpec = tween(durationMillis = 800)) togetherWith
                                fadeOut(animationSpec = tween(durationMillis = 800))
                    },
                    label = "size_selector_button_animation"
                ) { targetIsSelected ->
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .clickable { onClick(size) }
                            .background(
                                if (targetIsSelected) Color(0xFF7C351B)
                                else Color.Transparent
                            )
                            .padding(horizontal = 10.dp, vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = size,
                            color = if (targetIsSelected) Color(0xDEFFFFFF)
                            else Color(0x991F1F1F),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W700,
                            lineHeight = 10.sp,
                            fontFamily = UrbanistFontFamily
                        )
                    }
                }
            }
        }
    }
}
