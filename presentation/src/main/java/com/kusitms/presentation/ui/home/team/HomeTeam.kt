package com.kusitms.presentation.ui.home.team

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kusitms.domain.model.home.TeamMatchingModel
import com.kusitms.presentation.R
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo


@Composable
fun HomeTeam(
    team: List<TeamMatchingModel>,
    onClickTeam: () -> Unit,
) {
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
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.home_team),
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
                            text = team.size.toString(),
                            style = KusitmsTypo.current.Caption1,
                            color = KusitmsColorPalette.current.Main400,
                        )
                    }
                }
            }
            if (team.isNotEmpty()) {
                LazyRow(modifier = Modifier.fillMaxWidth(), content = {
                    items(team) { teamItem ->
                        TeamMatchingItem(teamItem = teamItem, onClickTeam)
                    }
                })
            } else {
                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.home_team_none),
                        style = KusitmsTypo.current.Caption1,
                        color = KusitmsColorPalette.current.Grey400,
                    )
                }
            }

        }
    }
}

@Composable
fun TeamMatchingItem(
    teamItem: TeamMatchingModel,
    onClickTeam: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(end = 12.dp, top = 12.dp)
            .clickable {
                onClickTeam()
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = KusitmsColorPalette.current.Grey600,
        )
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp),
        ) {
            Text(
                text = teamItem.curriculumName,
                style = KusitmsTypo.current.Text_Semibold,
                color = KusitmsColorPalette.current.Grey100
            )
        }
    }
}


