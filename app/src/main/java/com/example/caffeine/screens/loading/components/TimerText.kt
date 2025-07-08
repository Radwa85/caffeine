package com.example.caffeine.screens.loading.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.ui.theme.SnigletFamily


@Composable
fun TimerText() {
    val coffeeText = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color(0xFF7C351B))) {
            append("CO")
        }
        append(" ")
        withStyle(style = SpanStyle(color = Color(0x1F1F1F1F))) { // رمادي فاتح للفاصل
            append(":")
        }
        append(" ")
        withStyle(style = SpanStyle(color = Color(0xFF7C351B))) {
            append("FF")
        }
        append(" ")
        withStyle(style = SpanStyle(color = Color(0x1F1F1F1F))) {
            append(":")
        }
        append(" ")
        withStyle(style = SpanStyle(color = Color(0xFF7C351B))) {
            append("EE")
        }
    }

    Text(
        text = coffeeText,
        modifier = Modifier.padding(top = 12.dp),
        fontSize = 32.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = SnigletFamily,
        letterSpacing = 0.25.sp,
    )
}
