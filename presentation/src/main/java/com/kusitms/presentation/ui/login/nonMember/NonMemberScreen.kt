package com.kusitms.presentation.ui.login

import LoginLogoIv
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import androidx.compose.material.Text
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.ui.login.nonMember.NonMemberBanner
import com.kusitms.presentation.ui.login.nonMember.NonMemberLogo
import com.kusitms.presentation.ui.login.nonMember.NonMemberPage


@Composable
fun NonMemberScreen(navController: NavController) {
    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.nonMember_topbar),
        navController = rememberNavController()
    ) {
        NonMemberColumn()
    }

}

@Composable
fun NonMemberColumn() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = KusitmsColorPalette.current.Grey800)
        .padding(horizontal = 20.dp),
        horizontalAlignment =  Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(95.5.dp))
        NonMemberLogoColumn()
        Spacer(modifier = Modifier.weight(1f))
        NonMemberColumn2()
    }
}

@Composable
fun NonMemberLogoColumn() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(140.dp)
        .background(color = KusitmsColorPalette.current.Grey800),
        horizontalAlignment =  Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text= stringResource(id = R.string.nonMember_caption1),
            style = KusitmsTypo.current.Caption1,
            color = KusitmsColorPalette.current.Grey400
        )
        NonMemberLogo()

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .width(68.dp)
                .height(28.dp)
                .background(
                    color = KusitmsColorPalette.current.Grey600,
                    shape = RoundedCornerShape(size = 12.dp)
                )
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text= stringResource(id = R.string.nonMember_caption2),
                style = KusitmsTypo.current.Caption1,
                color = KusitmsColorPalette.current.Grey300,
                modifier = Modifier.padding(vertical = 2.dp)
            )
        }

    }
}

@Composable
fun NonMemberColumn2() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(400.dp),
        horizontalAlignment =  Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(0.dp))
        NonMemberPage()
        Spacer(modifier = Modifier.height(12.dp))
        NonMemberBanner()
        Spacer(modifier = Modifier.height(61.dp))
    }
}





@Preview(showBackground = true)
@Composable
fun snsSite() {
    NonMemberScreen(navController = rememberNavController())

}