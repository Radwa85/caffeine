package com.example.caffeine.screens.selectSnack.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import kotlin.math.abs

data class Snack(
    val id: Int,
    val name: String,
    val img: Int
)
val snacks = listOf(
    Snack(id = 0, img = R.drawable.chocolate, name = "Chocolate"),
    Snack(id = 1, img = R.drawable.cupcake, name = "Cupcake"),
    Snack(id = 2, img = R.drawable.cookies, name = "Cookies"),
    Snack(id = 3, img = R.drawable.cinnabon, name = "Cinnabon"),
    Snack(id = 4, img = R.drawable.cross, name = "Corso"),
    Snack(id = 5, img = R.drawable.oreo, name = "Oreo"),
)
@Composable
fun SnackPager(
    pagerState: PagerState = rememberPagerState(pageCount = { snacks.size }),
    onItemClick: (String) -> Unit = {}
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    VerticalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .offset(x = -screenWidth * 0.15f),
        contentPadding = PaddingValues(vertical = screenHeight * 0.25f),
        flingBehavior = PagerDefaults.flingBehavior(
            state = pagerState,
            snapAnimationSpec = tween(400)
        )
    ) { page ->
        val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

        val scale = when {
            abs(pageOffset) < 0.001f -> 1f
            pageOffset < 0f -> 1f - (0.1f * abs(pageOffset))
            else -> 1f - (0.2f * abs(pageOffset))
        }

        var rotationZ = -4f * pageOffset

        val offsetX = when {
            pageOffset < 0f -> screenWidth.value * 0.4f * pageOffset
            else -> -screenWidth.value * 0.5f * pageOffset
        }

        val offsetY = when {
            pageOffset < 0f -> screenHeight.value * 0.10f * pageOffset
            else -> screenHeight.value * 0.5f * pageOffset
        }

        Box(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale * 1.1f
                    scaleY = scale * 1.1f
                    rotationZ = rotationZ
                    translationX = offsetX
                    translationY = offsetY
                }
                .defaultMinSize(
                    minWidth = screenWidth * 0.6f,
                    minHeight = screenHeight * 0.7f
                )
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(32.dp)
                )
                .clickable {
                    onItemClick(snacks[page].id.toString())
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(snacks[page].img),
                contentDescription = snacks[page].name,
                modifier = Modifier.size(screenWidth * 0.4f),
                contentScale = ContentScale.Fit
            )
        }
    }
}
