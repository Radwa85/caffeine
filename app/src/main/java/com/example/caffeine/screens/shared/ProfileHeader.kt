package com.example.caffeine.screens.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.LightGray
import com.example.caffeine.ui.theme.PrimaryBlackAlpha87

@Composable
fun ProfileHeader(
    modifier: Modifier = Modifier,
    onAddClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile image
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "Profile",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        // Add button
        IconButton(
            onClick = onAddClick,
            modifier = Modifier
                .size(48.dp)
                .background(
                    color = LightGray,
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.add_01),
                contentDescription = "Add",
                modifier = Modifier.size(24.dp),
                tint = PrimaryBlackAlpha87
            )
        }
    }
}
