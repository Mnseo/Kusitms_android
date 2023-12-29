package com.kusitms.presentation.ui.profile.search

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kusitms.presentation.R
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
        cursorBrush = SolidColor(KusitmsColorPalette.current.Main500),
        maxLines = 1,
        singleLine = true,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(
                        color = KusitmsColorPalette.current.Grey600,
                        shape = RoundedCornerShape(12.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                Box{
                    if (text.isEmpty()) {
                        Text(
                            text = stringResource(R.string.profile_search_hint),
                            style = KusitmsTypo.current.Text_Medium,
                            color = KusitmsColorPalette.current.Grey400
                        )
                    }
                    innerTextField.invoke()
                }
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileSearchScreenPreview() {
    ProfileSearchScreen(
        onBackClick = {}
    )
}