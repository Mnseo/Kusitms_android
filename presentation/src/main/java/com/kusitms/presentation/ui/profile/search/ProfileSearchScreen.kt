package com.kusitms.presentation.ui.profile.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.profile.search.ProfileSearchViewModel
import com.kusitms.presentation.ui.ImageVector.LeftArrow

@Composable
fun ProfileSearchScreen(
    viewModel: ProfileSearchViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    val uiState = viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey900),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onBackClick()
                    },
                imageVector = LeftArrow.vector,
                contentDescription = "뒤로"
            )
            ProfileSearchField(
                text = uiState.value.searchText,
                onTextChange = { newText ->
                    viewModel.changeSearchText(newText)
                }
            )
        }
    }
}


@Composable
private fun ProfileSearchField(
    text: String,
    onTextChange: (String) -> Unit,
) {
    BasicTextField(
        value = text,
        onValueChange = onTextChange,
        textStyle = KusitmsTypo.current.Text_Medium.copy(color = KusitmsColorPalette.current.Grey100),
        decorationBox = { innerTextField ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = KusitmsColorPalette.current.Grey600,
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(start = 16.dp),
                    ) {
                    innerTextField()
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        },
        cursorBrush = SolidColor(KusitmsColorPalette.current.Main500)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileSearchScreenPreview() {
    ProfileSearchScreen(
        onBackClick = {}
    )
}