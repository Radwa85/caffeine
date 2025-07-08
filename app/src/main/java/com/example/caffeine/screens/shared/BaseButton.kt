package com.example.caffeine.screens.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.ui.theme.UrbanistFontFamily
import com.example.caffeine.ui.theme.PrimaryBlack
import com.example.caffeine.ui.theme.WhiteAlpha87
import androidx.compose.ui.text.font.FontWeight
import com.example.caffeine.extensions.dropShadow

@Composable
fun BaseButton(
    text: String,
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = 56.dp,
    horizontalPadding: Dp = 32.dp,
    verticalPadding: Dp = 16.dp,
    backgroundColor: Color = PrimaryBlack,
    textColor: Color = WhiteAlpha87
) {
    Row(
        modifier = modifier
            .height(height)
            .dropShadow(
                shape = RoundedCornerShape(100.dp),
                color = Color.Black.copy(alpha = 0.24f),
                blur = 12.dp,
                offsetX = 0.dp,
                offsetY = 10.dp,
                spread = 0.dp
            )
            .clip(RoundedCornerShape(100.dp))
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(horizontal = horizontalPadding, vertical = verticalPadding),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontFamily = UrbanistFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            color = textColor
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = textColor
        )
    }
}
