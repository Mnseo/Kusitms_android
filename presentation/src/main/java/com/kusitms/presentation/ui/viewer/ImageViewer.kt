package com.kusitms.presentation.ui.viewer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.KusitsmTopBarTextWithTwoIcons
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun ImageViewer() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        KusitsmTopBarTextWithTwoIcons(
            textContent = {
                Text(
                    text = "1/10",
                    textAlign = TextAlign.Center,
                    style = KusitmsTypo.current.SubTitle1_Semibold,
                    color = KusitmsColorPalette.current.Grey100
                )
            },
            firstIconContent = {
                Spacer(
                    modifier = Modifier
                        .size(20.dp)
                        .background(Color.White)
                )
            },
            secondIconContent = {
                Spacer(
                    modifier = Modifier
                        .size(20.dp)
                        .background(Color.White)
                )
            }
        )
    }
}