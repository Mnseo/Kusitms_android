package com.kusitms.presentation.ui.profile.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.KusitsmTopBarBackTextWithIcon
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo


@Composable
fun ProfileDetailScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey900),
    ) {
        KusitsmTopBarBackTextWithIcon(
            text = stringResource(id = R.string.profile_detail_topbar),
            onBackClick = { /*TODO*/ }) {
            Text(
                text = "차단",
                style = KusitmsTypo.current.Text_Medium,
                color = KusitmsColorPalette.current.Grey400
            )
        }
        Box(modifier = Modifier.padding(32.dp)) {
            ProfileDetailImage()
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileDetailScreenPreview() {
    ProfileDetailScreen(
    )
}