package com.example.caffeine.screens.coffeeType.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.caffeine.screens.customCoffee.components.CoffeeItem
import com.example.caffeine.screens.coffeeType.coffeeList

@Composable
fun CoffeePager(
    onSelectionChanged: (String) -> Unit
) {
    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp.dp
    val itemWidth = 208.dp
    val paddingValue = (screenWidth - itemWidth) / 2
    val pagerState = rememberPagerState(pageCount = { coffeeList.size })

    HorizontalPager(
        state = pagerState,
        pageSpacing = 8.dp,
        contentPadding = PaddingValues(horizontal = paddingValue),
        flingBehavior = PagerDefaults.flingBehavior(
            state = pagerState,
            snapAnimationSpec = tween(durationMillis = 300)
        ),
    ) { page ->
        val isSelected = pagerState.currentPage == page

        val scale = animateFloatAsState(
            targetValue = if (isSelected) 1f else 0.65f,
            animationSpec = tween(durationMillis = 300)
        )

        val offsetY = animateDpAsState(
            targetValue = if (isSelected) 0.dp else 10.dp,
            animationSpec = tween(durationMillis = 300)
        )

        if (isSelected) {
            onSelectionChanged(coffeeList[page].title)
        }

        Box(
            modifier = Modifier
                .scale(scale.value)
                .offset(y = offsetY.value)
        ) {
            CoffeeItem(coffeeList[page])
        }
    }
}
