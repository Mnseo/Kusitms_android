package com.kusitms.presentation.ui.home.team

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun HomeTeamDetailScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(KusitmsColorPalette.current.Grey700)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "기업 프로젝트",
                style = KusitmsTypo.current.Text_Semibold,
                color = KusitmsColorPalette.current.Grey100,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Card(
                shape = RoundedCornerShape(4.dp), colors = CardDefaults.cardColors(
                    containerColor = KusitmsColorPalette.current.Grey500,
                )
            ) {
                Box(modifier = Modifier.padding(horizontal = 5.dp)) {
                    Text(
                        text = "9",
                        style = KusitmsTypo.current.Caption1,
                        color = KusitmsColorPalette.current.Main400,
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painterResource(id = R.drawable.ic_hide),
                modifier = Modifier
                    .clickable {
                    },
                contentDescription = null
            )

        }
    }
}

@Preview
@Composable
fun HomeTeamDeatilScreenPreview() {
    HomeTeamDetailScreen(
    )
}