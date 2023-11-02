package com.kusitms.presentation.ui.login.manager

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo

@Composable
fun LoginManagerScreen() {
    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.login_manager_topbar),
        navController = rememberNavController()
    ) {
        LoginManagerColumn()
    }
}

@Composable
fun LoginManagerColumn() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = KusitmsColorPalette.current.Grey800)
        .padding(horizontal = 20.dp),
        horizontalAlignment =  Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(99.5.dp))
        LoginManagerColumn1()
        Spacer(modifier = Modifier.weight(1f))
        LoginManagerColumn2()
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun LoginManagerColumn1() {
    var example by remember { mutableStateOf("example") }
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(450.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        androidx.compose.material3.Text(
            text= stringResource(id = R.string.login_manager_title),
            style = KusitmsTypo.current.SubTitle2_Semibold,
            color = KusitmsColorPalette.current.Grey300
        )
        Spacer(modifier = Modifier.height(72.dp))
        LoginManagerInputColumn(
            id = example,
            pw = example,
            onIdChange = {newValue-> example = newValue},
            onPwChange = {newValue-> example = newValue}
        )
    }
}

@Composable
fun LoginManagerColumn2() {
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
                .fillMaxWidth()
                .height(56.dp),
            onClick = {

                Log.d("Click", "go to SignIn")
            },
            colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Main500),
            shape = RoundedCornerShape(size = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.login_member_btn2), style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey100)
        }
    }
}

@Preview
@Composable
fun previewLoginMember() {
    LoginManagerScreen()
}
