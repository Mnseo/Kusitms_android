package com.kusitms.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette



@Composable
fun TestScreen() {

}

@Preview(showBackground = true)
@Composable
fun Test() {
    Box(
        Modifier
            .width(400.dp)
            .background(color = KusitmsColorPalette.current.Main700)
            .height(400.dp)) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = KusitmsColorPalette.current.Main500)
        )
    }
}
