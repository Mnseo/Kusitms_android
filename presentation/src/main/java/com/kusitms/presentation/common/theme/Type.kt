package com.kusitms.presentation.common.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

data class CustomTypography(
    val Header1: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize =  28.sp,
        lineHeight = 36.sp,
        letterSpacing = (-1.5).sp
    ),
    val Header2: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize =  24.sp,
        lineHeight = 32.sp,
        letterSpacing = (-1.5).sp
    ),

    val SubTitle1_Medium: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize =  20.sp,
        lineHeight = 28.sp,
        letterSpacing = (-1.5).sp
    ),
    val SubTitle1_Semibold: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize =  20.sp,
        lineHeight = 28.sp,
        letterSpacing = (-1.5).sp
    ),

    val SubTitle2_Medium: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize =  18.sp,
        lineHeight = 24.sp,
        letterSpacing = (-1.5).sp
    ),
    val SubTitle2_Semibold: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize =  18.sp,
        lineHeight = 24.sp,
        letterSpacing = (-1.5).sp
    ),

    val Text_Medium: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize =  16.sp,
        lineHeight = 24.sp,
        letterSpacing = (-1.5).sp
    ),
    val Text_Semibold: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize =  16.sp,
        lineHeight = 24.sp,
        letterSpacing = (-1.5).sp
    ),

    val Caption1: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize =  14.sp,
        lineHeight = 20.sp,
        letterSpacing = (-1.5).sp
    ),
    val Caption2: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize =  12.sp,
        lineHeight = 18.sp,
        letterSpacing = (-1.5).sp
    ),

    val Body1: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize =  16.sp,
        lineHeight = 24.sp,
        letterSpacing = (-1.5).sp
    ),
    val Body2: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize =  14.sp,
        lineHeight = 22.sp,
        letterSpacing = (-1.5).sp
    ),



    )
val KustimsTypo = staticCompositionLocalOf { CustomTypography() }