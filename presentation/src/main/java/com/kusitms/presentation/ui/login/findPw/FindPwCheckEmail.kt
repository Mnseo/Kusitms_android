package com.kusitms.presentation.ui.login.findPw

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kusitms.presentation.R
import com.kusitms.presentation.common.theme.KusitmsScaffoldNonScroll
import com.kusitms.presentation.common.ui.theme.KusitmsColorPalette
import com.kusitms.presentation.model.login.findPw.FindPwViewModel


@Composable
fun FindPwCheckEmail(navController:NavHostController, viewModel: FindPwViewModel) {
    val email by viewModel.email.collectAsState()
    val isValid by viewModel.isValid.observeAsState(false)

    KusitmsScaffoldNonScroll(
        topbarText = stringResource(id = R.string.find_pw_topbar),
        navController = navController
    ) {
        FindPw1Column(email, isValid,
            onEmailChange = {viewModel.updateEmail(it)},
            navController = navController
        )
    }
}

@Composable
fun FindPw1Column(email: String, isValid:Boolean, onEmailChange: (String) -> Unit, navController: NavHostController) {
    var example by remember { mutableStateOf("examples") }
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = KusitmsColorPalette.current.Grey800)
            .padding(horizontal = 20.dp),
            horizontalAlignment =  Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(148.dp))
            FindPwEmailInput(email = email, onEmailChange = onEmailChange)
            Spacer(modifier = Modifier.weight(1f))
            FindPwBtn(R.string.find_pw_btn1,isValid, navController)
            Spacer(modifier = Modifier.height(24.dp))
        }
}


@Preview
@Composable
fun PreviewFindPw1() {
    FindPwCheckEmail(rememberNavController(), FindPwViewModel())
}
