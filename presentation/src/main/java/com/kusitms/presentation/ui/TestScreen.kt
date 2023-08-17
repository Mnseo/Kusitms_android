package com.kusitms.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette



@Composable
fun TestScreen() {

}


@Composable
fun Color(color: Long): Color {
    return Color(value = (color.toULong()and 0xffffffffUL) shl 32)
}

@Preview(showBackground = true, widthDp =  200, heightDp = 200)
@Composable
fun Test() {
    Box(modifier = Modifier.padding(12.dp)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(listOf(Color.Red, Color.Blue)),
                    shape = CircleShape,
                    alpha = 0.4f
                )
        ) {}
    }
}
