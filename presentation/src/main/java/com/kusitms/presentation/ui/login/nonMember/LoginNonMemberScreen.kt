package com.kusitms.presentation.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo


@Composable
fun NonMemberScreen(navController: NavController) {
    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.login_member_id_caption)
    ) {

    }

}






@Preview(showBackground = true)
@Composable
fun snsSite() {
    NonMemberScreen(navController = rememberNavController())

}