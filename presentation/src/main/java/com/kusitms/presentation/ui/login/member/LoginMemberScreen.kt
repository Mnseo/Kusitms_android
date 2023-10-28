package com.kusitms.presentation.ui.login.member

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo


@Composable
fun LoginMemberScreen() {
    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.signin_member_hint1_1),
    ) {
        LoginMemberColumn()
    }
}

@Composable
fun LoginMemberColumn() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = KusitmsColorPalette.current.Grey800)
        .padding(horizontal = 20.dp),
        horizontalAlignment =  Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.weight(1f))
        LoginMemberColumn1()
        Spacer(modifier = Modifier.weight(1f))
        LoginMemberColumn2()
    }
}

@Composable
fun LoginMemberColumn1() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(128.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        androidx.compose.material3.Text(
            text= stringResource(id = R.string.login_member_title),
            style = KusitmsTypo.current.SubTitle2_Semibold,
            color = KusitmsColorPalette.current.Grey300
        )
        Spacer(modifier = Modifier.height(72.dp))
        LoginMemberInputColumn()
    }
}

@Composable
fun LoginMemberInputColumn() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(128.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

    }
}

@Composable
fun


@Composable
fun LoginMemberColumn2() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(128.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        androidx.compose.material3.Text(
            text = stringResource(id = R.string.login_member_btn1),
            style = KusitmsTypo.current.Text_Semibold,
            color = KusitmsColorPalette.current.Grey400,
            modifier = Modifier.padding(start = 20.dp, top = 16.dp, bottom = 16.dp, end = 20.dp)
        )
        Button(
            modifier = Modifier
                .weight(1f)
                .height(56.dp),
            onClick = {

                Log.d("Click", "go to SignIn")
            },
            colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Main500),
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Text(text = stringResource(id = R.string.login_member_btn2), style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey100)
        }
    }
}


@Preview
@Composable
fun previewLoginMember() {
    LoginMemberScreen()
}