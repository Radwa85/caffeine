package com.example.caffeine.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.caffeine.R

//val RobotoFamily = FontFamily(
//    Font(R.font.roboto_regular, FontWeight.Normal)
//)

val UrbanistFontFamily = FontFamily(
    Font(R.font.urbanist_regular, FontWeight.Normal),
    Font(R.font.urbanist_medium, FontWeight.Medium),
    Font(R.font.urbanist_bold, FontWeight.Bold)
)
val SnigletFamily = FontFamily(
    Font(R.font.sniglet_regular, FontWeight.Normal),
    Font(R.font.sniglet_extra, FontWeight.ExtraBold)
)



// Font families



// Typography
val AppTypography = Typography(

      bodyMedium = TextStyle(
        //fontFamily = RobotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = SnigletFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 50.sp,
        letterSpacing = 0.25.sp
    ),
      labelLarge = TextStyle(
        fontFamily = UrbanistFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        letterSpacing = 0.25.sp
    ),
     titleLarge = TextStyle(
        fontFamily = UrbanistFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 0.25.sp,
        color = TextPrimary
    )
    , labelMedium = TextStyle(
        fontFamily = UrbanistFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp,
        color = TextSecondary
    )
,     labelSmall = TextStyle(
        fontFamily = UrbanistFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        letterSpacing = 0.25.sp,
        color = TextSecondary
    ),

)