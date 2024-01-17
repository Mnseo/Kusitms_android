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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun HomeCurriculumNone() {
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
                    text = stringResource(id = R.string.home_curriculum),
                    style = KusitmsTypo.current.Caption1,
                    color = KusitmsColorPalette.current.Main400,
                )
                Text(
                    text = stringResource(id = R.string.home_curriculum_title),
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
                            contentDescription = stringResource(id = R.string.home_ic_calendar),
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = stringResource(id = R.string.home_curriculum_calendar),
                            style = KusitmsTypo.current.Caption1,
                            color = KusitmsColorPalette.current.Grey300
                        )
                    }
                    Row(modifier = Modifier.padding(bottom = 12.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_location),
                            contentDescription = stringResource(id = R.string.home_ic_location),
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = stringResource(id = R.string.home_curriculum_location),
                            style = KusitmsTypo.current.Caption1,
                            color = KusitmsColorPalette.current.Grey300
                        )
                    }
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ic_wifi),
                            contentDescription = stringResource(id = R.string.home_ic_wifi),
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = stringResource(id = R.string.home_curriculum_wifi_none),
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
    HomeCurriculumNone()
}