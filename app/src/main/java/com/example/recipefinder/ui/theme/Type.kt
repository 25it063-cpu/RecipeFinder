package com.example.recipefinder.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AppTypography = Typography(

    headlineLarge = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        color = AppColors.PrimaryText
    ),

    titleMedium = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold
    ),

    bodyMedium = TextStyle(
        fontSize = 14.sp,
        color = AppColors.SecondaryText
    ),

    labelSmall = TextStyle(
        fontSize = 12.sp,
        color = AppColors.SecondaryText
    )
)