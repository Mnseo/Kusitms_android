package com.kusitms.presentation.ui.profile.search

import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.common.ui.KusitsmTopBarBackTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette

@Composable
fun ProfileSearchScreen(
    onBack: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey900),
    ) {
        KusitsmTopBarBackTextWithIcon(
            text = "",
            onBackClick = {
                onBack()
            },
        ) {
//            BasicTextField(
//                value = text,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(48.dp),
//                onValueChange = { text = it }
//            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileSearchScreenPreview() {
    ProfileSearchScreen(
        onBack = {}
    )
}