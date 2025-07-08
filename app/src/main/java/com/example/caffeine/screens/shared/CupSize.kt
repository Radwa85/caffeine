package com.example.caffeine.screens.shared

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R

@Composable
fun CupSize(selectedSize: String) {
    val cupData = remember {
        mapOf(
            "S" to Pair(154.dp, "150 ML"),
            "M" to Pair(199.dp, "200 ML"),
            "L" to Pair(245.dp, "400 ML")
        )
    }

    val logoSizeData = remember {
        mapOf(
            "S" to 40.dp,
            "M" to 64.dp,
            "L" to 64.dp
        )
    }

    val targetCupImageSize = cupData[selectedSize]?.first ?: 199.dp
    val targetMlText = cupData[selectedSize]?.second ?: "200 ML"
    val targetLogoSize = logoSizeData[selectedSize] ?: 64.dp

    val animatedCupSize by animateDpAsState(
        targetValue = targetCupImageSize,
        animationSpec = tween(durationMillis = 300), label = "cup_size_animation"
    )

    val animatedLogoSize by animateDpAsState(
        targetValue = targetLogoSize,
        animationSpec = tween(durationMillis = 300), label = "logo_size_animation"
    )

    val fixedContainerHeight = 310.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding( start = 16.dp)
            .height(fixedContainerHeight)
    ) {

        AnimatedContent(
            targetState = targetMlText,
            transitionSpec = {
                fadeIn(animationSpec = tween(700)) togetherWith
                        fadeOut(animationSpec = tween(700))
            }, label = "ml_text_animation"
        ) { currentMlText ->
            Text(
                text = currentMlText,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 54.dp, end = 16.dp),
                color = Color(0x99000000)
            )
        }
        Image(
            painter = painterResource(R.drawable.cup_200),
            contentDescription = "Product Image",
            modifier = Modifier
                .size(animatedCupSize)
                .align(Alignment.Center)
        )
        Image(
            painter = painterResource(R.drawable.tc_logo),
            contentDescription = "Product Logo",
            modifier = Modifier
                .size(animatedLogoSize)
                .align(Alignment.Center)
        )
    }

}