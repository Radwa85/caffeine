package com.example.caffeine.screens.ghostScreen.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.AppTypography
import com.example.caffeine.ui.theme.PrimaryBlackAlpha87

@Composable
fun CoffeeContent(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "ghostFloat")

    val ghostOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 20f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1500,
                easing = EaseInOutSine
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "ghostFloating"
    )
    val shadowAlpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1500,
                easing = EaseInOutSine
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "shadowAlpha"
    )

    val starsAlpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1200,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "starsAlpha"
    )


    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(R.drawable.star),
                contentDescription = "Stars",
                modifier = Modifier
                    .size(20.dp)
                    .offset(x = 100.dp,y =20.dp )
                    .graphicsLayer {
                        alpha = starsAlpha
                    },
                contentScale = ContentScale.Fit
            )
            Text(
                text = "Hocus\nPocus\nI Need Coffee\nto Focus",
                style = AppTypography.headlineLarge,
                color = PrimaryBlackAlpha87,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(188.dp)
                    .padding( bottom = 33.dp)
            )

            Image(
                painter = painterResource(R.drawable.star),
                contentDescription = "Stars",
                modifier = Modifier
                    .size(20.dp)
                    .offset(x = 100.dp, y = -40.dp)
                    .graphicsLayer {
                        alpha = starsAlpha
                    },
                contentScale = ContentScale.Fit
            )
            Image(
                painter = painterResource(R.drawable.star),
                contentDescription = "Stars",
                modifier = Modifier
                    .size(20.dp)
                    .offset(x = -100.dp,y =-185.dp )
                    .graphicsLayer {
                        alpha = starsAlpha
                    },
                contentScale = ContentScale.Fit
            )
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.sshadow),
                    contentDescription = "Coffee Ghost Shadow",
                    modifier = Modifier
                        .size(197.dp, 48.dp)
                        .offset(y = (140.dp - (ghostOffset * 0.25f).dp))
                        .graphicsLayer {
                            alpha = shadowAlpha
                        },
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    painter = painterResource(R.drawable.ghost),
                    contentDescription = "Coffee Ghost",
                    modifier = Modifier
                        .size(244.dp)
                        .offset(y = (-ghostOffset).dp),
                    contentScale = ContentScale.Fit
                )

            }
        }
    }
}