package com.kusitms.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun HomeNotice() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = CardDefaults.cardColors(
            containerColor = KusitmsColorPalette.current.Grey900,
        ),
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_notice),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "최신 공지가 올라오는 곳이에요",
                    style = KusitmsTypo.current.Text_Semibold,
                    color = KusitmsColorPalette.current.White
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeNoticePreview() {
    HomeNotice()
}