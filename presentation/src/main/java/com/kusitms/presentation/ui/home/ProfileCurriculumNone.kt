package com.kusitms.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun HomeCurriculum() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = KusitmsColorPalette.current.Grey800,
        )
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 16.dp)
                .fillMaxWidth(), verticalArrangement = Arrangement.Top
        ) {
            Column(
                modifier = Modifier.height(56.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "다가오는 커리큘럼",
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Main400,
                )
                Text(
                    text = "큐시즘 전체 OT",
                    style = KusitmsTypo.current.SubTitle1_Medium,
                    color = KusitmsColorPalette.current.White,
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = KusitmsColorPalette.current.Grey600,
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 16.dp)
                ) {
                    Row(modifier = Modifier.padding(bottom = 12.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_calendar),
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "9월 16일 토 15:00~17:00",
                            style = KusitmsTypo.current.Caption1,
                            color = KusitmsColorPalette.current.Grey300
                        )
                    }
                    Row(modifier = Modifier.padding(bottom = 12.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_location),
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "서울창업허브 9층",
                            style = KusitmsTypo.current.Caption1,
                            color = KusitmsColorPalette.current.Grey300
                        )
                    }
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ic_wifi),
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "와이파이 정보가 없어요",
                            style = KusitmsTypo.current.Caption1,
                            color = KusitmsColorPalette.current.Grey400
                        )
                    }
                }


            }
        }
    }
}

@Preview
@Composable
fun HomeCurriculumPreview() {
    HomeCurriculum()
}