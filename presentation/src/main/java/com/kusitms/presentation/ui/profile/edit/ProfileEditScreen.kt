package com.kusitms.presentation.ui.profile.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitsmTopBarBackTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun ProfileEditScreen(
) {
    Column {
        KusitsmTopBarBackTextWithIcon(
            text = stringResource(id = R.string.profile_edit_toolbar),
            onBackClick = {},
        ) {
            Text(
                text = stringResource(id = R.string.profile_edit_modify),
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Main400,
                modifier = Modifier.clickable {

                }
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(KusitmsColorPalette.current.Grey900)
        ) {

        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileEditScreenPreview() {
    ProfileEditScreen()
}
