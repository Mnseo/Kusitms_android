package com.kusitms.presentation.common.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ColorPalette(
    val White: Color = Color(0xFFFFFFFF),
    val Black: Color = Color(0xFF000000),

    //Grey Color
    val Grey900: Color = Color(0xFF0F1011),
    val Grey800: Color = Color(0xFF15171E),
    val Grey700: Color = Color(0xFF171A21),
    val Grey600: Color = Color(0xFF20232D),
    val Grey500: Color = Color(0xFF363C48),
    val Grey400: Color = Color(0xFF727783),
    val Grey300: Color = Color(0xFFD9DCE1),
    val Grey200: Color = Color(0xFFE8EBEF),
    val Grey100: Color = Color(0xFFF4F6F8),

    //Main Color 1 = blue
    val Main900: Color = Color(0xFF102E6A),
    val Main800: Color = Color(0xFF153C8B),
    val Main700: Color = Color(0xFF1B4DB3),
    val Main600: Color = Color(0xFF2363E5),
    val Main500: Color = Color(0xFF266DFC),
    val Main400: Color = Color(0xFF518AFD),
    val Main300: Color = Color(0xFF6E9DFD),
    val Main200: Color = Color(0xFFBCD2FE),
    val Main100: Color = Color(0xFFE9F0FF),

    //Main Color 2 = green
    val Main2_900: Color = Color(0xFF2A615D),
    val Main2_800: Color = Color(0xFF387F7A),
    val Main2_700: Color = Color(0xFF48A49E),
    val Main2_600: Color = Color(0xFF5CD2CA),
    val Main2_500: Color = Color(0xFF65E7DE),
    val Main2_400: Color = Color(0xFF84ECE5),
    val Main2_300: Color = Color(0xFF98EFE9),
    val Main2_200: Color = Color(0xFFB8F4F0),
    val Main2_100: Color = Color(0xFFCFF8F5),

    //Sub Color = Positive / Negative
    val Sub1: Color = Color(0xFF65E7DE),
    val Sub2: Color = Color(0xFFFE6F7B),

    val GreyBlack7 : Color = Color(0xFF959698)

    )

data class ColorPalette1(
    val Gray950: Color = Color(0xFF191919),
    val Gray900: Color = Color(0xFF212121),
    val Gray700: Color = Color(0xFF444444),
    val Gray550: Color = Color(0xFF6E6E6E),
    val Gray500: Color = Color(0xFF828282),
    val Gray400: Color = Color(0xFFA6A6A6),
    val Gray300: Color = Color(0xFFC9C9C9),
    val Gray200: Color = Color(0xFFE9E9E9),
    val Gray50: Color = Color(0xFFF5F5F5),

    val Error300: Color = Color(0xFFFC4E6D),
    val TMTMBlue200: Color = Color(0xFF96D7FF),
    val TMTMBlue400: Color = Color(0xFF36B2FF),
    val color_button_active: Color = Color(0xFF44AEFF),
    val GreyWhite: Color = Color(0xFFFFFFFF),
    val ColorDivider: Color = Color(0xFFF0F0F0),
    val color_text_body_quaternary : Color = Color(0xFF828282),
    val color_text_body_primary: Color = Color(0xFF444444),
    val color_text_body_quinary: Color = Color(0xFFC9C9C9),
    val elevation_color_elevation_level01: Color = Color(0xFFF5F5F5),
)

val KusitmsColorPalette = staticCompositionLocalOf { ColorPalette() }
val TmtmColorPalette = staticCompositionLocalOf { ColorPalette1() }