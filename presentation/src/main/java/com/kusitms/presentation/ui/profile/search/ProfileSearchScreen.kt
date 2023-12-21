package com.kusitms.presentation.ui.profile.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette

@Composable
fun ProfileSearchScreen(
    onBack : () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey900),
    ) {}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileSearchScreenPreview(){
    ProfileSearchScreen(
        onBack = {},
    )
}