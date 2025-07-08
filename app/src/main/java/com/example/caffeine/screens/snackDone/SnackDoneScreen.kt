package com.example.caffeine.screens.snackDone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.Navigation.AppDestination
import com.example.caffeine.R

import com.example.caffeine.screens.shared.CancelButton
import com.example.caffeine.screens.selectSnack.components.snacks
import com.example.caffeine.screens.shared.BaseButton
import com.example.caffeine.ui.theme.SnigletFamily

import com.example.caffeine.ui.theme.UrbanistFontFamily

@Composable
fun SnackDoneScreen(
    navController: NavController,
    snackId: String
) {
    val selectedSnack = snacks.find { it.id == snackId.toIntOrNull() }
    val imageResId = selectedSnack?.img ?: R.drawable.cross
    Scaffold(
        containerColor = Color.White
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .padding(vertical = 16.dp),

            horizontalAlignment = CenterHorizontally,

            ) {
            CancelButton(bottomSpace = 24.dp, modifier = Modifier.padding(horizontal = 16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Icon(
                    painter = painterResource(R.drawable.coffee_beans__1_),
                    contentDescription = "Product Image",
                    modifier = Modifier.size(32.dp),
                    tint = Color(0xFF7C351B),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "More Espresso, Less Depresso",
                    color = Color(0xFF7C351B),
                    fontSize = 20.sp,
                    lineHeight = 10.sp,
                    letterSpacing = 0.25.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = SnigletFamily
                )
                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    painter = painterResource(R.drawable.coffee_beans__1_),
                    contentDescription = "Product Image",
                    modifier = Modifier.size(32.dp),
                    tint = Color(0xFF7C351B),

                    )
            }
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Snack Image",
                modifier = Modifier
                    .height(310.dp)
                    .width(300.dp)
            )
            Row(
                modifier = Modifier.padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Bon appétit",
                    color = Color(0xCC1F1F1F),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = UrbanistFontFamily,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Image(
                    painter = painterResource(R.drawable.magic_wand_01),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "magic wand",

                    )

            }
            Spacer(modifier = Modifier.weight(1f))
            BaseButton(
                onClick = { navController.navigate(AppDestination.GhostScreen.route)},
                text = "Thank youuu",
                icon = painterResource(R.drawable.arrow)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

    }
}





