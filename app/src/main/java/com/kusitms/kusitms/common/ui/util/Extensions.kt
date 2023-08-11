package com.kusitms.kusitms.common.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp


@Composable
fun Dp.dpToPx() = with(LocalDensity.current) {
    this@dpToPx.toPx()
}

@Composable
fun Int.pxTodp() = with(LocalDensity.current) {
    this@pxTodp.toDp()
}