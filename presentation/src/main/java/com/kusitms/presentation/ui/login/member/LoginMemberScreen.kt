package com.kusitms.presentation.ui.login.member

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.common.ui.theme.KusitmsTypo
import com.kusitms.presentation.model.login.LoginStatus
import com.kusitms.presentation.model.login.LoginViewModel
import com.kusitms.presentation.navigation.NavRoutes


@Composable
fun LoginMemberScreen(
    navController: NavHostController,
    viewModel: LoginViewModel
) {
    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.login_member_topbar),
        navController = navController
    ) {
        LoginMemberColumn(viewModel, navController)
    }
}

@Composable
fun LoginMemberColumn(viewModel: LoginViewModel, navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = KusitmsColorPalette.current.Grey900)
        .padding(horizontal = 20.dp),
        horizontalAlignment =  Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(99.5.dp))
        LoginMemberColumn1(viewModel)
        Spacer(modifier = Modifier.weight(1f))
        LoginMemberColumn2(viewModel, navController)
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun LoginMemberColumn1(viewModel: LoginViewModel) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(450.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        androidx.compose.material3.Text(
            text= stringResource(id = R.string.login_member_title),
            style = KusitmsTypo.current.SubTitle2_Semibold,
            color = KusitmsColorPalette.current.Grey300
        )
        Spacer(modifier = Modifier.height(72.dp))
        LoginMemberInputColumn(viewModel = viewModel)
    }
}


@Composable
fun LoginMemberColumn2(viewModel: LoginViewModel, navController: NavHostController) {
    val loginStatus by viewModel.loginStatus.collectAsState()
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
            modifier = Modifier
                .padding(start = 20.dp, top = 16.dp, bottom = 16.dp, end = 20.dp)
                .clickable { navController.navigate(NavRoutes.FindPwCheckEmail.route) }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            onClick = { viewModel.validateLogin()
                if(loginStatus == LoginStatus.SUCCESS)
                    navController.navigate(NavRoutes.SignInDefault.route)
            },
            colors = ButtonDefaults.buttonColors(containerColor = KusitmsColorPalette.current.Main500),
            shape = RoundedCornerShape(size = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.login_member_btn2), style = KusitmsTypo.current.Text_Semibold, color = KusitmsColorPalette.current.Grey100)
        }
    }
}