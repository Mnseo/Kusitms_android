package com.kusitms.presentation.ui.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun HomeScreen(navController: NavHostController) {
    KusitmsScaffoldNonScroll(
        topbarText = "홈화면",
        navController = navController
    ) {
        HomeColumn()
    }
}

@Composable
fun HomeColumn() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = KusitmsColorPalette.current.Grey900)
        .padding(horizontal = 20.dp),
        horizontalAlignment =  Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "홈화면", style = KusitmsTypo.current.SubTitle2_Semibold, color = KusitmsColorPalette.current.Grey300 )
    }
}

@Preview
@Composable
fun HomePreview() {
    HomeScreen(navController = rememberNavController())
}