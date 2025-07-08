package com.example.caffeine.screens.customCoffee.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import kotlinx.coroutines.delay

@Composable
fun FallingBeans(
    triggerDrop: Int,
    onAnimationComplete: () -> Unit,
    cupSize: String,
    modifier: Modifier = Modifier,
    direction: BeanAnimationDirection = BeanAnimationDirection.DOWN
) {
    var offsetY by remember { mutableStateOf(0.dp) }
    var isAnimating by remember { mutableStateOf(false) }

    val startOffsetY = when (direction) {
        BeanAnimationDirection.DOWN -> (-LocalConfiguration.current.screenHeightDp.dp / 2)
        BeanAnimationDirection.UP -> 120.dp
    }

    val endOffsetY = when (direction) {
        BeanAnimationDirection.DOWN -> 120.dp
        BeanAnimationDirection.UP -> (-500).dp
    }

    val animatedOffsetY by animateDpAsState(
        targetValue = offsetY,
        animationSpec = tween(durationMillis = 1000),
        label = "beans_movement"
    )

    val currentAlpha by remember(animatedOffsetY, direction) {
        derivedStateOf {
            val startPx = startOffsetY.value
            val endPx = endOffsetY.value
            val currentPx = animatedOffsetY.value
            val progress = ((currentPx - startPx) / (endPx - startPx)).coerceIn(0f, 1f)
            if (direction == BeanAnimationDirection.DOWN) 1f - progress else 1f - (1f - progress)
        }
    }

    val beanImageRes = when (cupSize) {
        "S" -> R.drawable.beans_small
        "M", "L" -> R.drawable.beans_large
        else -> R.drawable.beans_large
    }

    LaunchedEffect(triggerDrop) {
        if (triggerDrop > 0) {
            isAnimating = true
            offsetY = startOffsetY
            delay(50)
            offsetY = endOffsetY
            delay(1000)
            isAnimating = false
            onAnimationComplete()
        }
    }

    if (isAnimating) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .offset(y = animatedOffsetY)
                .graphicsLayer(alpha = currentAlpha),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = beanImageRes),
                contentDescription = "Falling Coffee Beans",
                modifier = Modifier.size(100.dp)
            )
        }
    }
}

enum class BeanAnimationDirection {
    UP, DOWN
}